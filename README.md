# Java-JSON-Collection

Java-JSON-Collection is a port of my Node.JS Library for managing data. It has been inspired by the Discord.JS Collection.

## Installation
Download the JAR file [here](https://github.com/Hanyaku-Chan/Java-JSON-Collection/releases/download/Releases/JsonCollection-1.0-SNAPSHOT.jar)

``` YML
<dependency>
    <groupId>eu.gworks</groupId>
    <artifactId>jsoncollection</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/path_to_the_file/JsonCollection-1.0-SNAPSHOT.jar</systemPath>
</dependency>
```

## Usage

``` Java
import eu.gworks.JsonCollection;

public class Project {

  JsonCollection Collection = new JsonCollection();

  public static void main(String[] args) {

    Collection.set("name", "value");

    System.out.print(Collection.get("name"));

  }
}
```

You can also store a required file or another Collection inside a Collection.

You can save and load the Data.

```java
import eu.gworks.JsonCollection;

public class Project {

  JsonCollection Collection = new JsonCollection();

  public static void main(String[] args) {

    Collection.load("./file.json");

    Collection.save("./file.json");

  }
}
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[GNU AGPLv3](https://choosealicense.com/licenses/agpl-3.0/)
