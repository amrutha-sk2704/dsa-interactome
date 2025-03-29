package com.example.demo.trie;

import org.springframework.stereotype.Service;

@Service
public class TrieService {

    private final Trie trie = new Trie();

    public TrieService() {
        // Initialize the trie with interactions
        trie.insert("aspirin+benadryl", "NO EFFECT", " ");
        trie.insert("aspirin+aminosalicylic", "NO EFFECT", " ");
        trie.insert("aspirin+bromocriptine", "NO EFFECT", "");
        trie.insert("heparin+amlodipine", "NO EFFECT", "");
        trie.insert("heparin+insulin", "NO EFFECT", "");
        trie.insert("heparin+bromocriptine", "NO EFFECT", "");
        trie.insert("heparin+aminosalicylic", "NO EFFECT", "");
        trie.insert("insulin+heparin", "NO EFFECT", "");
        trie.insert("insulin+amlodipine", "NO EFFECT", "");
        trie.insert("insulin+ibuprofen", "NO EFFECT", "");
        trie.insert("insulin+warfarin", "NO EFFECT", "");
        trie.insert("warfarin+amlodipine", "NO EFFECT", "");
        trie.insert("warfarin+insulin", "NO EFFECT", "");
        trie.insert("warfarin+bromocriptine", "NO EFFECT", "");
        trie.insert("warfarin+aminosalicylic", "NO EFFECT", "");
        trie.insert("ibuprofen+insulin", "NO EFFECT", "");
        trie.insert("ibuprofen+benadryl", "NO EFFECT", "");
        trie.insert("ibuprofen+aminosalicylic", "NO EFFECT", "");
        trie.insert("ibuprofen+bromocriptine", "NO EFFECT", "");

        trie.insert("aspirin+metoprolol", "MILD EFFECT", "Aspirin + metoprolol affects blood pressure at times");

        trie.insert("aspirin+heparin", "MODERATE EFFECT", "Aspirin + heparin causes gastrointestinal bleeding");
        trie.insert("aspirin+amlodipine", "MODERATE EFFECT", "Aspirin + amlodipine increases blood pressure");
        trie.insert("aspirin+insulin", "MODERATE EFFECT", "Aspirin + insulin has high risk of hypoglycemia aka low blood sugar");
        trie.insert("heparin+aspirin", "MODERATE EFFECT", "Heparin + aspirin causes gastrointestinal bleeding");
        trie.insert("heparin+ibuprofen", "MODERATE EFFECT", "Heparin + ibuprofen causes bleeding, blood in your urine or stools, headache, dizziness, or weakness");
        trie.insert("insulin+aspirin", "MODERATE EFFECT", "Insulin + aspirin has high risk of hypoglycemia aka low blood sugar and symptoms following it");
        trie.insert("insulin+metoprolol", "MODERATE EFFECT", "Insulin + metoprolol has high risk of hypoglycemia aka low blood sugar and symptoms following it");
        trie.insert("ibuprofen+heparin", "MODERATE EFFECT", "Ibuprofen + heparin causes bleeding, blood in your urine or stools, headache, dizziness, or weakness");
        trie.insert("ibuprofen+amlodipine", "MODERATE EFFECT", "Ibuprofen + amlodipine increases blood pressure");

        trie.insert("aspirin+ibuprofen", "MAJOR EFFECT", "Aspirin + ibuprofen causes gastrointestinal ulcers and bleeding");
        trie.insert("aspirin+warfarin", "MAJOR EFFECT", "Aspirin + warfarin causes bleeding, blood in your urine or stools, headache, dizziness, or weakness");
        trie.insert("heparin+warfarin", "MAJOR EFFECT", "Heparin + warfarin causes bleeding, blood in your urine or stools, headache, dizziness, or weakness");
        trie.insert("warfarin+aspirin", "MAJOR EFFECT", "Warfarin + aspirin causes bleeding, blood in your urine or stools, headache, dizziness, or weakness");
        trie.insert("warfarin+heparin", "MAJOR EFFECT", "Warfarin + heparin causes bleeding, blood in your urine or stools, headache, dizziness, or weakness");
        trie.insert("warfarin+ibuprofen", "MAJOR EFFECT", "Warfarin + ibuprofen causes serious intestinal bleeding, tarry stools");
        trie.insert("ibuprofen+aspirin", "MAJOR EFFECT", "Ibuprofen + aspirin causes gastrointestinal ulcers and bleeding");
        trie.insert("ibuprofen+warfarin", "MAJOR EFFECT", "Ibuprofen + warfarin causes serious intestinal bleeding, tarry stools");
    }


    public InteractionResult checkInteraction(String drug1, String drug2) {
        Trie.TrieNode result = trie.search(drug1 + "+" + drug2);
        if (result == null) {
            result = trie.search(drug2 + "+" + drug1);
        }
        if (result != null) {
            return new InteractionResult(result.label, result.detail);
        } else {
            return new InteractionResult("No Interaction Detected", "");
        }
    }

    public static class InteractionResult {
        private String label;
        private String detail;

        public InteractionResult(String label, String detail) {
            this.label = label;
            this.detail = detail;
        }

        public String getLabel() {
            return label;
        }

        public String getDetail() {
            return detail;
        }
    }
}