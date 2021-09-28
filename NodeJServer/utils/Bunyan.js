let bunyan = require('bunyan');
let bformat = require('bunyan-format');
let formatOut = bformat({ outputMode: 'short' });
let fs = require('fs');
let path = process.cwd();

module.exports = function(name) {
    return bunyan.createLogger(
    {
        name: name,
        streams: [
            {
                level: 'error',
                stream: getStream('error.json')
            },
            {
                level: 'trace',
                stream: getStream('trace.json')
            },
            {
                level: 'debug',
                stream: getStream('debug.json')
            },
            {
                level: 'info',
                stream: getStream('info.json')
            },
            {
                level: 'warn',
                stream: getStream('warn.json')
            },
            {
                stream: formatOut
            }]
    });
};

function getStream(file) {
    return fs.createWriteStream(path + '/logs/' + file);
}