//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package car.command;

import car.Car;
import java.awt.Color;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Script {
    List<Command> commands = new ArrayList();

    public Script() {
    }

    public void add(Command command) {
        this.commands.add(command);
    }

    public void execute() {
        Iterator var1 = this.commands.iterator();

        while(var1.hasNext()) {
            Command command = (Command)var1.next();
            command.execute();
        }

    }

    public static Script load(InputStreamReader isr, Car car) {
        try {
            Scanner scanner = new Scanner(isr);

            Script var15;
            try {
                Script script = new Script();

                while(scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    StringTokenizer st = new StringTokenizer(line);
                    String command = st.nextToken();
                    String parameter = st.nextToken();
                    System.out.println("command = " + command + " paramener=" + parameter);

                    Color color;
                    try {
                        color = (Color)Color.class.getField(parameter).get((Object)null);
                    } catch (Exception var12) {
                        color = null;
                    }

                    switch (command) {
                        case "down":
                            script.add(new DownCommand(car, Integer.parseInt(parameter)));
                            break;
                        case "right":
                            script.add(new RightCommand(car, Integer.parseInt(parameter)));
                            break;
                        case "left":
                            script.add(new LeftCommand(car, Integer.parseInt(parameter)));
                            break;
                        case "up":
                            script.add(new UpCommand(car, Integer.parseInt(parameter)));
                            break;
                        case "leftdown":
                            script.add(new LeftDownCommand(car, Integer.parseInt(parameter)));
                            break;
                        case "leftup":
                            script.add(new LeftUpCommand(car, Integer.parseInt(parameter)));
                            break;
                        case "rightdown":
                            script.add(new RightDownCommand(car, Integer.parseInt(parameter)));
                            break;
                        case "rightup":
                            script.add(new RightUpCommand(car, Integer.parseInt(parameter)));
                            break;
                        case "changecolor":
                            script.add(new ColorCommand(car, color));
                            break;
                        case "name":
                            script.add(new NameCommand(car, parameter));
                            break;
                        case "speed":
                            script.add(new SpeedCommand(car, Integer.parseInt(parameter)));
                            break;

                        default:
                            System.out.println("Unknown command = "+command);
                    }
                }

                var15 = script;
            } catch (Throwable var13) {
                try {
                    scanner.close();
                } catch (Throwable var11) {
                    var13.addSuppressed(var11);
                }

                throw var13;
            }

            scanner.close();
            return var15;
        } catch (Exception var14) {
            var14.printStackTrace();
            return null;
        }
    }
}
