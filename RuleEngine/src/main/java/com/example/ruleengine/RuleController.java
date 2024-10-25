package com.example.ruleengine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rules")
public class RuleController {
    @Autowired
    private RuleService ruleService;

    @Autowired
    private RuleRepository ruleRepository;

    @PostMapping
    public ResponseEntity<Rule> createRule(@RequestBody Rule rule) {
        Node ast = ruleService.createRule(rule.getRuleString());
        // Optionally save the AST or other metadata if needed
        Rule savedRule = ruleRepository.save(rule);
        return ResponseEntity.ok(savedRule);
    }

    @GetMapping
    public List<Rule> getAllRules() {
        return ruleRepository.findAll();
    }

    @PostMapping("/evaluate")
    public ResponseEntity<Boolean> evaluateRule(@RequestBody Map<String, Object> data) {
        // Placeholder for AST; you might want to load it based on specific rules
        Node ast = new Node("operator", null, null, "AND"); // Replace with actual AST
        boolean result = ruleService.evaluateRule(ast, data);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/combine")
    public ResponseEntity<Node> combineRules(@RequestBody List<String> rules) {
        Node combinedAST = ruleService.combineRules(rules);
        return ResponseEntity.ok(combinedAST);
    }

}
