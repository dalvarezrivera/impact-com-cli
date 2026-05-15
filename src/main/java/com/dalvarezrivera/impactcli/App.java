package com.dalvarezrivera.impactcli;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(
        name = "impact-com",
        mixinStandardHelpOptions = true,
        version = "impact-com-cli 1.0.0",
        description = "Prints the name of the company I'm applying to: impact.com.%n" +
                "Built with picocli (https://picocli.info) as part of an application by " +
                "Daniel Alvarez <dalvarezrivera@uvic.ca>."
)
public final class App implements Callable<Integer> {

    private static final String COMPANY = "impact.com";

    @Option(
            names = {"-p", "--plain"},
            description = "Print only the company name, no banner."
    )
    private boolean plain;

    @Option(
            names = {"-l", "--loud"},
            description = "Print the company name in uppercase."
    )
    private boolean loud;

    @Override
    public Integer call() {
        String name = loud ? COMPANY.toUpperCase() : COMPANY;

        if (plain) {
            System.out.println(name);
            return 0;
        }

        String banner = """
                ╔══════════════════════════════════════════╗
                ║                                          ║
                ║              %s              ║
                ║                                          ║
                ╚══════════════════════════════════════════╝
                """.formatted(centered(name, 14));

        System.out.println(banner);
        System.out.println("  Hi impact.com — thanks for reading the bonus section.");
        System.out.println("  — Daniel Alvarez");
        return 0;
    }

    private static String centered(String value, int width) {
        if (value.length() >= width) {
            return value;
        }
        int totalPad = width - value.length();
        int left = totalPad / 2;
        int right = totalPad - left;
        return " ".repeat(left) + value + " ".repeat(right);
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
