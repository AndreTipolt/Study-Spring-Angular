const PROXY_CONFIG = [
    {
        context: ['/api'],
        target: 'http://localhost:8080/',
        secure: false,
        logLebel: 'debug'
    },
]

module.exports = PROXY_CONFIG