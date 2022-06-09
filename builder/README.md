Builder - Design pattern
==========================================
> I used lombok @Builder annotation (if you want the details of the impl have a look here: [https://projectlombok.org/features/Builder](https://projectlombok.org/features/Builder))
## Pro
* Avoid having a telescoping constructors
* Improve readability
* Handy during writing of Unit Tests

## Cons
* Easy to forget a mandatory parameter (the build method can perform some check but this will be detected only at Runtime)
  * If you need to have a compile time check have a look at [Step Builder pattern](../step-builder/README.md) which address that gracefully.
