package com.example.demo.trie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TrieController {

    @Autowired
    private TrieService trieService;

    @PostMapping("/check")
    public TrieService.InteractionResult checkInteraction(@RequestParam String drug1, @RequestParam String drug2) {
        return trieService.checkInteraction(drug1, drug2);
    }
}
