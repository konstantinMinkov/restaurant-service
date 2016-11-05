var gulp = require('gulp');
var sass = require('gulp-sass');
var concat = require('gulp-concat');
var cleanCss = require('gulp-clean-css');
var inject = require('gulp-inject');
var uglify = require('gulp-uglify');
var rename = require('gulp-rename');
var runSequence = require('gulp-run-sequence');

gulp.task('styles', function() {
    gulp.src('src/main/site/sass/**/*.scss')
        .pipe(sass().on('error', sass.logError))
        .pipe(concat('styles.css'))
        .pipe(gulp.dest('./src/main/webapp/resources/css/'))
        .pipe(cleanCss())
        .pipe(rename({suffix: '.min'}))
        .pipe(gulp.dest('./src/main/webapp/resources/css/'));
});

gulp.task('scripts', function() {
    gulp.src(['src/main/site/js/app.js', 'src/main/site/js/*/*.js'])
        .pipe(concat('app.js'))
        .pipe(gulp.dest('./src/main/webapp/resources/js/'))
        .pipe(uglify())
        .pipe(rename({suffix: '.min'}))
        .pipe(gulp.dest('./src/main/webapp/resources/js/'));
});

gulp.task('inject', function() {
    gulp.src('./src/main/webapp/index.html')
        .pipe(inject(gulp.src('./src/main/webapp/resources/css/*.min.css'), {relative: true}))
        .pipe(inject(gulp.src('./src/main/webapp/resources/js/*.min.js'), {relative: true}))
        .pipe(gulp.dest('./src/main/webapp/index.html'));
});

gulp.task('default', runSequence('styles', 'scripts', 'inject'));

gulp.task('watcher', function() {
    gulp.watch('src/sass/**/*.scss', ['styles', 'inject']);
    gulp.watch('src/js/**/*.js', ['scripts', 'inject']);
});