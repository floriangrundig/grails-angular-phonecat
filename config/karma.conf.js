basePath = '../';

files = [
  JASMINE,
  JASMINE_ADAPTER,
  'web-app/lib/angular/angular.js',
  'web-app/lib/angular/angular-*.js',
  'test/lib/angular/angular-mocks.js',
  'web-app/js/**/*.js',
  'test/unit/**/*.js'
];

autoWatch = true;

browsers = ['Chrome'];

junitReporter = {
  outputFile: 'target/test_out/unit.xml',
  suite: 'unit'
};
