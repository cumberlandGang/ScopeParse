# ScopeParse
ScopeParse is a simple Java library for parsing information out of collections, where infinitely nested structures exist. For instance, take the following Java class as an example:

**Example1**


```C#
class foo1 {
      class foo2 {
      	    class foo3 {
	    }
    }
}
```

In this case, `foo1` lies within the global scope. foo2 is within foo1's scope. foo3 is within foo1 and foo2's scope. So... How can we parse something like this? Splitting the string on the
ending delimiter (}) won't work, because it leaves out the full story. So we need ScopeParse to properly return the scopes.

Ideally, scopeparse(Example1, '{', '}') should give us the following value:

```C#
class foo2 {
      class foo3 {
      }
}
```

This way, nested structures can be passed back into the parser for recursive descent without using a more intense strategy (monadic parsing, regular expressions, etc).

## Advantages

* The total size of the ScopeParse library should be very small in comparison with professional parsers.
* ScopeParse will be applicable to any collection in Java, not just String or String[].

## Disadvantages
* ScopeParse lacks most features of a true parsing library, so it is not suitable in large projects.
* ScopeParse's complexity tends to be higher than that of monadic parsers, so it may not be suitable for large inputs.

# Authors
Nathaniel Pisarski <nathanpisarski@gmail.com>

# License
MIT