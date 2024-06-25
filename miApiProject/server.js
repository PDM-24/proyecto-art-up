const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');

const app = express();
const port = 3000;

// Middleware
app.use(bodyParser.json());

// Conexión a MongoDB
mongoose.connect('mongodb+srv://root:root@cluster0.dmjlraw.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0', { useNewUrlParser: true, useUnifiedTopology: true })
    .then(() => console.log('MongoDB connected'))
    .catch(err => console.log(err));

// Importar rutas
const institutionRoutes = require('./routes/institutionroutes');
const eventRoutes = require('./routes/eventroutes');
const postRoutes = require('./routes/postroutes');
const userRoutes = require('./routes/userroutes');
const saleRoutes = require('./routes/saleroutes');

// Usar rutas
app.use('/institutions', institutionRoutes);
app.use('/events', eventRoutes);
app.use('/posts', postRoutes);
app.use('/users', userRoutes);
app.use('/sales', saleRoutes);

app.listen(port, () => {
    console.log(`Server running on port ${port}`);
});
