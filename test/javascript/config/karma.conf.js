module.exports = function (config) {
    config.set({

        basePath: './../../../',
        files: [
            'web-app/lib/angular/angular.js',
            'web-app/lib/angular/angular.js',
            'web-app/lib/angular/angular-loader.js',
            'web-app/lib/angular/angular-resource.js',
            'web-app/lib/angular/angular-sanitize.js',
            'test/javascript/lib/angular/angular-mocks.js',
            'web-app/js/*.js',
            'test/javascript/unit/**/*.js'
        ],

        browsers: [ 'Chrome'],
        reporters: ['remote'],
        frameworks: ["jasmine"],
        autoWatch: false,
        singleRun: true,
        remoteReporter: {
            host: 'localhost',
            port: '9877'
        },
        plugins: [
            'karma-jasmine',
            'karma-chrome-launcher',
            'karma-remote-reporter'
        ]
    });
};