# impact-com-cli

A tiny Java CLI that prints **impact.com**.

Built with [picocli](https://picocli.info) as a bonus to my application for the
Java software engineer role at [impact.com](https://impact.com).

— Daniel Alvarez · [dalvarezrivera@uvic.ca](mailto:dalvarezrivera@uvic.ca)

## Run

Requires Java 17+ and Maven.

```bash
mvn -q package
java -jar target/impact-com-cli.jar
```

Output:

```
╔══════════════════════════════════════════╗
║                                          ║
║                impact.com                ║
║                                          ║
╚══════════════════════════════════════════╝

  Hi impact.com.
  — Daniel Alvarez
```

## Options

```bash
java -jar target/impact-com-cli.jar --help
```

| Flag              | Effect                              |
| ----------------- | ----------------------------------- |
| `-p`, `--plain`   | Print only `impact.com`, no banner. |
| `-l`, `--loud`    | Uppercase the company name.         |
| `-h`, `--help`    | picocli-generated help.             |
| `-V`, `--version` | Print version and exit.             |

## Why picocli

Picocli is the de-facto standard for Java CLIs — annotation-driven, supports
subcommands, ANSI colors, completion scripts, and produces a `--help` that
looks great out of the box. For a one-line program it's overkill on purpose;
the goal is to show idiomatic Java tooling, not just `System.out.println`.
