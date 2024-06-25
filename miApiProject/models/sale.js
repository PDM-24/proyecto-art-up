const mongoose = require('mongoose');

const SaleSchema = new mongoose.Schema({
    username: { type: String, required: true },
    image: { type: String, required: true },
    price: { type: Number, required: true },
    description: { type: String, required: true }
});

module.exports = mongoose.model('Sale', SaleSchema);
