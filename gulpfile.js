var gulp = require('gulp');
var sass = require('gulp-sass');
var concat = require('gulp-concat');
var cleanCss = require('gulp-clean-css');
var inject = require('gulp-inject');
var uglify = require('gulp-uglify');
var rename = require('gulp-rename');
var runSequence = require('gulp-run-sequence');
var concatVendor = require('gulp-concat-vendor');
var templateCache = require('gulp-angular-templatecache');
var buildSemantic = require('./semantic/tasks/build');

gulp.task('templates', function () {
    gulp.src('src/main/site/*/*.html')
        .pipe(templateCache(
            'templates.js',
            {
                module: 'restaurant-service',
                transformUrl: function (url) {
                    return url.substring(url.lastIndexOf('\\') + 1);
                }
            }
        ))
        .pipe(gulp.dest('src/main/webapp/resources'))
});

gulp.task('js', function() {
    gulp.src([
        'src/main/site/app.module.js',
        'src/main/site/app.config.js',
        'src/main/site/*/*.js'
    ])
        .pipe(concat('app.js'))
        .pipe(gulp.dest('./src/main/webapp/resources'))
        .pipe(uglify())
        .pipe(rename({suffix: '.min'}))
        .pipe(gulp.dest('./src/main/webapp/resources'));
});

gulp.task('vendor-js', function() {
    gulp.src('./bower_components/*')
        .pipe(concatVendor('vendor.js'))
        .pipe(gulp.dest('./src/main/webapp/resources'))
        .pipe(uglify())
        .pipe(rename({suffix: '.min'}))
        .pipe(gulp.dest('./src/main/webapp/resources'));
});

gulp.task('semantic-ui', buildSemantic);
gulp.task('dev', runSequence('templates', 'vendor-js', 'js'));

///todo !
// gulp.task('inject', function() {
//     gulp.src('./src/main/site/index.html')
//         .pipe(inject(gulp.src('./src/main/webapp/resources/*.css'), {relative: true}))
//         .pipe(inject(gulp.src('./src/main/webapp/resources/*.min.js'), {relative: true}))
//         .pipe(gulp.dest('./src/main/webapp/'));
// });
//
// gulp.task('styles', function() {
//     gulp.src('src/main/site/sass/**/*.scss')
//         .pipe(sass().on('error', sass.logError))
//         .pipe(concat('styles.css'))
//         .pipe(gulp.dest('./src/main/webapp/resources/css/'))
//         .pipe(cleanCss())
//         .pipe(rename({suffix: '.min'}))
//         .pipe(gulp.dest('./src/main/webapp/resources/css/'));
// });
//
// gulp.task('watcher', function() {
//     gulp.watch('src/sass/**/*.scss', ['styles', 'inject']);
//     gulp.watch('src/js/**/*.js', ['scripts', 'inject']);
// });