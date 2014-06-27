module.exports = function (config) {
    config.set({

        basePath: './../../../',
        files: [
            'grails-app/assets/javascripts/vendor/angular/angular.js',
            'grails-app/assets/javascripts/vendor/angular/angular.js',
            'grails-app/assets/javascripts/vendor/angular/angular-loader.js',
            'grails-app/assets/javascripts/vendor/angular/angular-resource.js',
            'test/javascript/lib/angular/angular-mocks.js',
            'grails-app/assets/javascripts/app/*.js',
            'test/javascript/unit/**/*.js'
        ],

        browsers: [ 'PhantomJS'],
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
            'karma-phantomjs-launcher',
            'karma-remote-reporter'
        ]
    });
};