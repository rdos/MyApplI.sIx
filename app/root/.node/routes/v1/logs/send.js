const logger = require('/home/rdos/D/MyApplication/NodeJServer/utils/Bunyan')("logs.send");

const PRIORITY_INFO = "4";
const PRIORITY_WARN = "5";
const PRIORITY_VERBOSE = "2";
const PRIORITY_DEBUG = "3";
const PRIORITY_ERROR = "6";

module.exports = async function(req, res) {
    const priority = req.body.priority;
    const line = getLogLine(req);

    if (priority === PRIORITY_INFO) {
        logger.info(line)
    }

    else if (priority === PRIORITY_WARN) {
        logger.warn(line)
    }

    else if (priority === PRIORITY_VERBOSE) {
        logger.trace(line)
    }

    else if (priority === PRIORITY_DEBUG) {
        logger.debug(line)
    }

    else if (priority === PRIORITY_ERROR) {
        logger.error(line)
    }

    res.send({status: "ok"})
};

function getLogLine(req) {
    const tag = req.body.tag;
    const message = req.body.message;
    const date = req.body.date;

    return tag + ": " + message + ", when: " + date
}