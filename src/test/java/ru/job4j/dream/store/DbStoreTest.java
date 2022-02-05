package ru.job4j.dream.store;

import org.junit.Test;
import ru.job4j.dream.model.Post;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

public class DbStoreTest {
    @Test
    public void whenCreatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.save(post);
        Post postInDb = store.findPostById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenUpdatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.save(post);
        post.setName("Python Job");
        store.save(post);
        Post postInDb = store.findPostById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenDeleteAllPosts() {
        DbStore store = (DbStore) DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.save(post);
        store.deleteAllPosts();
        assertThat(store.findAllCandidates(), is(new ArrayList<>()));
    }

    @Test
    public void whenDeletePostByID() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.save(post);
        store.deletePost(post.getId());
        assertNull(store.findPostById(post.getId()));
    }
}