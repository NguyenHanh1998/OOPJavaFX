# Dictionary models

## Class

### Word
- Overview
Contain data of a word

- Attributes
    - word: String
    - mean: String

- Methods
    - getWord(): return word
    - getMean(): return mean
    - setWord(): change word
    - setMean(): change mean

### DatabaseManager
- Overview
Contain query logic to get/update/delete data from database

- Interface : IDatabaseManager

- Attributes : none

- Methods
    - connect(): setup connection to database
    - insertDictionary(String name): insert a new Dictionary to database
    - deleteDictionary(int id): delete an exist Dictionary from database
    - insertWord(int id, String word, String mean): insert a new Word to database
    - deleteWord(int id, String word): delete an exist Word from database
    - updateWord(int id, String word, String newWord): change word
    - updateMean(int id, String word, String mean): change mean
    - getWord(int id, String word): get word from database

### Dictionary
- Overview
Contain user behavior

- Attributes
    - dictionaryId: int
    - dbm: DatabaseManager

- Method
    - Dictionary(String dictionaryName): open an Dictionary
    - search(String word): return a word from Dictionary
    - insertWord(String word, String mean): insert a word to Dictionary
    - updateWord(String word, String newWord): update a word in Dictionary
    - updateMean(String word, String mean): update a word's mean in Dictionary
    - deleteWord(String word): delete a word in Dictionary

## Usage

### Testing
```shell
    javac Main.java
    java -classpath ".;sqlite-jdbc-3.21.0.jar" Main
```

### Build Project
Add sqlite-jdbc-3.21.0.jar in to external lib

