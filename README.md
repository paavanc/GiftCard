# GiftCard
Running Locally:
Pre-req: Java8 and Maven3
Installation for mac:
1.Install HomeBrew: /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
2.Install Java:
  a.brew tap caskroom/versions
  b.brew cask install java8
3.Install Maven: brew install maven
In the terminal, run the following command in the GiftCard directory.
1.mvn package
-should run all the tests and package up a jar in the GiftCard/target directory
2. cd into GiftCard/target 
3.run the command:java -jar price-0.0.1-SNAPSHOT.jar /Your/local/path/prices.txt 2500
  -the first argument is the text file, the second is an int representing the target
Example:
prices.txt
Candy Bar, 500
Paperback Book, 700
Detergent, 1000
Headphones, 1400
Earmuffs, 2000
Bluetooth Stereo, 6000

java -jar price-0.0.1-SNAPSHOT.jar /Your/local/path/prices.txt 2500
Candy Bar 500, Earmuffs 2000

Performance:
This solution runs in O(n) and has the same space complexity.  We iterate through all the lines of the file till
we find the best combination.

Assumptions:
Assume the file and target are the right formats and in order.

Important files:
/src/main/java/com/giftcard/price/manager/impl/GiftCardManagerImpl.java - source code
/src/test/java/com/giftcard/price/PriceApplicationTests.java - tests
