# Kotlin Kata Starter
A starting point for a [code kata](http://codekata.com/) in Kotlin using IntelliJ.

### Prerequisites

1. [IntelliJ](https://www.jetbrains.com/idea/download/#section=mac)
### Up & Running

```
git clone https://github.com/aedenj/kotlin-kata-starter.git ~/projects/katas/hard-problem
cd ~/projects/katas/hard-problem;rm -rf .git;idea .
```
Since I frequently use this project I like to wrap everything up in an alias like this,

```
alias kks='f(){ git clone git@github.com:aedenj/kotlin-kata-starter.git $1; cd $1;rm -rf .git; idea .; unset -f f; }; f'
```

Usage:

```
kks ~/somem-path-of-your-choice
```

Follow the usual TDD process of red, green and refactor.
