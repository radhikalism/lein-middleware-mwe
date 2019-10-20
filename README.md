This minimal working example demonstrates (maybe) some unexpected
behaviour in Leiningen middleware handling.

[Tested on Leiningen 2.9.1 on Java 11.0.4 OpenJDK 64-Bit Server VM]

`lein-middleware-mwe-plugin/` is a trivial Leiningen plugin
generated with `lein new plugin` and amended with a non-implicit
middleware function that prints some info and calls System/exit.

Projects using this plugin's middleware should find that executing
`lein` invokes the middleware function and causes the JVM to exit
with some info message.

`lein-middleware-mwe-testproject-with-implicits/` is such a project
which includes the middleware function explicitly in its
`:middleware [...]` declaration. But it also leaves `:implicits`
and `:implicit-middleware` being `true` (as default).

`lein-middleware-mwe-testproject-without-implicits/` is also such
a project which includes the middleware function explicitly in its
`:middleware [...]` declaration. But it declares `:implicits`
and/or `:implicit-middleware` being `false` (non-default).

Both test projects are linked to the plugin using `.lein-classpath`.

To reproduce the problem:

* Enter the `...with-implicits/` directory
* Execute: `$ lein`
* **Expect:** an info message is printed, then the process exits
* **Actual:** an info message is printed, then the process exits

Then:

* Enter the `...without-implicits/` directory
* Execute: `$ lein`
* **Expect:** an info message is printed, then the process exits
* **Actual:** default lein help is printed, not an info message
  from the middleware function

The last scenario is unexpected, given that the middleware
declaration is explicit, so disabling implicit middleware should
have no effect.
