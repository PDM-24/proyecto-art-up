const express = require('express');
const router = express.Router();
const Post = require('../.models/post');

// Obtener todos los posts
router.get('/', async (req, res) => {
    try {
        const posts = await Post.find();
        res.json(posts);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

// Crear un nuevo post
router.post('/', async (req, res) => {
    const post = new Post({
        title: req.body.title,
        category: req.body.category
    });
    try {
        const newPost = await post.save();
        res.status(201).json(newPost);
    } catch (err) {
        res.status(400).json({ message: err.message });
    }
});

module.exports = router;
