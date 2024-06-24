const express = require('express');
const router = express.Router();
const Institution = require('../models/institucion');

// Obtener todas las instituciones
router.get('/', async (req, res) => {
    try {
        const institutions = await Institution.find();
        res.json(institutions);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

// Crear una nueva institución
router.post('/', async (req, res) => {
    const institution = new Institution({
        name: req.body.name
    });
    try {
        const newInstitution = await institution.save();
        res.status(201).json(newInstitution);
    } catch (err) {
        res.status(400).json({ message: err.message });
    }
});

module.exports = router;
