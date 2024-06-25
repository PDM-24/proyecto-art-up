const express = require('express');
const router = express.Router();
const Sale = require('../models/sale');

// Obtener todas las ventas
router.get('/', async (req, res) => {
    try {
        const sales = await Sale.find();
        res.json(sales);
    } catch (err) {
        res.status(500).json({ message: err.message });
    }
});

// Crear una nueva venta
router.post('/', async (req, res) => {
    const sale = new Sale({
        date: req.body.date,
        amount: req.body.amount,
        quantity: req.body.quantity,
        product: req.body.product
    });
    try {
        const newSale = await sale.save();
        res.status(201).json(newSale);
    } catch (err) {
        res.status(400).json({ message: err.message });
    }
});

module.exports = router;
