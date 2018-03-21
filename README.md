# standings

A [re-frame](https://github.com/Day8/re-frame) application designed to help learn reframe. 
The goal is to learn how to update only part of a page.

Currently, the app consists of 5 divs.  One for each NFC division of the NFL and one div to enter 
two teams and a score of a game.  Clicking the submit button will determine the winner and update
the record for each team.

Currently, there is no error checking so the team names have to be correct and the scores should be numbers.
In the current state, the app shows the problem that I am trying to learn how to solve which is, even when
both teams are from the same division, the application re-draws all divisions. 

I want to learn how to set up the views so that only the divisions that are updated will get re-drawn.
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
