const mongoose = require('mongoose');

const SaleSchema = new mongoose.Schema({
    date: { type: Date, required: true },
    amount: { type: Number, required: true },
    quantity: { type: Number, required: true },
    product: { type: String, required: true }
});

module.exports = mongoose.model('Sale', SaleSchema);
