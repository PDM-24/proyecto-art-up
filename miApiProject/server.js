const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');

const app = express();
const port = 3000;

// Middleware
app.use(bodyParser.json());

// Conexión a MongoDB
mongoose.connect('mongodb://localhost:27017/mydatabase', { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => console.log('MongoDB connected'))
    .catch(err => console.log(err));

// Importar rutas
const institutionRoutes = require('./routes/institutionRoutes');
const eventRoutes = require('./routes/eventRoutes');
const postRoutes = require('./routes/postRoutes');
const userRoutes = require('./routes/userRoutes');
const saleRoutes = require('./routes/saleRoutes');

// Usar rutas
app.use('/institutions', institutionRoutes);
app.use('/events', eventRoutes);
app.use('/posts', postRoutes);
app.use('/users', userRoutes);
app.use('/sales', saleRoutes);

app.listen(port, () => {
    console.log(`Server running on port ${port}`);
});
