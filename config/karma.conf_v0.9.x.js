module.exports = function (config) {
    config.set({

        basePath: '../',
        files: [
            'web-app/lib/angular/angular.js',
            'web-app/lib/angular/angular.js',
            'web-app/lib/angular/angular-loader.js',
            'web-app/lib/angular/angular-resource.js',
            'web-app/lib/angular/angular-sanitize.js',
            'test/lib/angular/angular-mocks.js',
            'web-app/js/*.js',
            'test/unit/**/*.js'
        ],

        //  export PHANTOMJS_BIN=/Users/florian/opt/phantomjs-1.8.1-macosx/bin/phantomjs
        browsers: ['PhantomJS', 'Chrome'],
        reporters: ['progress', 'junit', 'coverage'],
        frameworks: ["jasmine"],
        autoWatch: false,
        junitReporter: {
            outputFile: 'target/test_out/unit.xml',
            suite: 'unit'
        },
        plugins: [
            'karma-jasmine',
            'karma-coverage',
            'karma-chrome-launcher',
            'karma-phantomjs-launcher',
            'karma-junit-reporter'
        ]
    });
};