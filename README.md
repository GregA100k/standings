# standings

A [re-frame](https://github.com/Day8/re-frame) application designed to help learn reframe. 
The goal is to learn how to update only part of a page.

## Development Mode

### Run application:

```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Production Build


To compile clojurescript to javascript:

```
lein clean
lein cljsbuild once min
```