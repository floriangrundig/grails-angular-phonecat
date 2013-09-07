module.exports = function (config) {
    config.set({

        basePath: './../../../',
        files: [
            'test/javascript/e2e/**/*.js'
        ],

        //  export PHANTOMJS_BIN=/Users/florian/opt/phantomjs-1.8.1-macosx/bin/phantomjs
        browsers: ['Chrome'],

        reporters: ['remote'],

        frameworks: ['ng-scenario'],
        autoWatch: false,

        singleRun: true,

        proxies: {
            '/': 'http://localhost:8080/angular-phonecat/',
            '/angular-phonecat': 'http://localhost:8080/angular-phonecat/',
            '/angular-phonecat/static': 'http://localhost:8080/angular-phonecat/static'
        },

        urlRoot: '/__karma/',
        remoteReporter: {
            host: 'localhost',
            port: '9876'
        },

        plugins: [
            'karma-jasmine',
            'karma-chrome-launcher',
            'karma-ng-scenario',
            'karma-remote-reporter'
        ]
    });
};

