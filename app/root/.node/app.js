const express = require('express');
const helmet = require('helmet');
const bodyParser = require('body-parser');
const logs_send = require('./routes/v1/logs/send');
const fs = require('fs');
const https = require('https');
const constants = require('./config');
const app = express();

app.set('view engine', 'jade');
app.use(helmet());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

app.use('/api/v1/logs.send', logs_send);
app.listen(3600);

module.exports = app;