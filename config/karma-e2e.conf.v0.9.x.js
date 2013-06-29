module.exports = function (config) {
    config.set({

        basePath: '../',
        files: [
            ANGULAR_SCENARIO,
            ANGULAR_SCENARIO_ADAPTER,
            'test/e2e/**/*.js'
        ],

        //  export PHANTOMJS_BIN=/Users/florian/opt/phantomjs-1.8.1-macosx/bin/phantomjs
        browsers: ['PhantomJS', 'Chrome'],
        reporters: ['progress', 'junit', 'coverage'],
        frameworks: ["jasmine"],
        autoWatch: false,

        singleRun: true,

        proxies: {
            '/': 'http://localhost:8080/angular-phonecat/',
            '/angular-phonecat': 'http://localhost:8080/angular-phonecat/',
            '/angular-phonecat/static': 'http://localhost:8080/angular-phonecat/'
        },

        urlRoot: '/__karma/',

        junitReporter: {
            outputFile: 'target/test_out/e2e.xml',
            suite: 'e2e'
        },
        plugins: [
            'karma-jasmine',
            'karma-chrome-launcher',
            'karma-phantomjs-launcher',
            'karma-ng-scenario',
            'karma-junit-reporter'
        ]
    });
};


autoWatch = false;

browsers = ['Chrome', 'Safari', 'PhantomJS'];
