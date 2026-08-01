package org.example.restassignment.controllers;

import org.example.restassignment.errors.StudentNotFound;
import org.example.restassignment.models.DTOs.RequestDTOs.RequestLoginDTO;
import org.example.restassignment.models.DTOs.RequestDTOs.RequestUpdate;
import org.example.restassignment.models.DTOs.RequestDTOs.StudentSignUpRequest;
import org.example.restassignment.models.DTOs.ResponseDTOs.FoundStudent;
import org.example.restassignment.services.FilterWhoPassAndTheFirstOneRanked;
import org.example.restassignment.services.StudentDeleteOrUpdateOrFindService;
import org.example.restassignment.services.StudentServiceLogInSignUp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentServiceLogInSignUp authService = new StudentServiceLogInSignUp();
    private final StudentDeleteOrUpdateOrFindService studentService = new StudentDeleteOrUpdateOrFindService();
    private final FilterWhoPassAndTheFirstOneRanked rankingService = new FilterWhoPassAndTheFirstOneRanked();

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody StudentSignUpRequest request) {
        int id = authService.signup(request);
        Map<String, Object> body = new HashMap<>();
        body.put("id", id);
        body.put("message", "Student created");
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody RequestLoginDTO request) throws Exception {
        boolean authenticated = authService.login(request);
        Map<String, Object> body = new HashMap<>();
        body.put("authenticated", authenticated);

        if (!authenticated) {
            body.put("message", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
        }

        return ResponseEntity.ok(body);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoundStudent> getStudentById(@PathVariable int id) {
        FoundStudent found = studentService.findStudnet(id);
        if (found == null) {
            throw new StudentNotFound("Student not found");
        }
        return ResponseEntity.ok(found);
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> updateStudent(@RequestBody RequestUpdate requestUpdate) {
        studentService.updateStudent(requestUpdate);
        Map<String, Object> body = new HashMap<>();
        body.put("message", "Student updated");
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/passed")
    public ResponseEntity<List<String>> getPassedStudents() {
        return ResponseEntity.ok(rankingService.getWhoPass());
    }

    @GetMapping("/top")
    public ResponseEntity<Map<String, Object>> getTopStudent() {
        String topName = rankingService.getTheNumberOne();
        Map<String, Object> body = new HashMap<>();
        body.put("name", topName);
        return ResponseEntity.ok(body);
    }

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(StudentNotFound ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneric(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }



}

