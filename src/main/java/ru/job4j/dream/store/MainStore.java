package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

public class MainStore {
    public static void main(String[] args) {
        Store store = DbStore.instOf();

        Post post = new Post(0, "Java Job");
        Candidate candidate = new Candidate(0, "Vasilij Nikolaevich Shtolts");

        store.save(post);
        store.save(candidate);

        for (Post p : store.findAllPosts()) {
            System.out.println(p.getId() + " " + p.getName());
        }

        for (Candidate c : store.findAllCandidates()) {
            System.out.println(c.getId() + " " + c.getName());
        }

        store.save(new Post(post.getId(), "Python"));
        store.deleteCandidate(candidate.getId());

        for (Post p : store.findAllPosts()) {
            System.out.println(p.getId() + " " + p.getName());
        }

        for (Candidate c : store.findAllCandidates()) {
            System.out.println(c.getId() + " " + c.getName());
        }
    }
}