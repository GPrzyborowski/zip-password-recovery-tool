# Zip Password Recovery Tool

## Important Note
This tool is intended for personal and lawful use only. Users are fully responsible for ensuring their actions comply with applicable laws and regulations. The author explicitly disclaims any liability for the manner in which the tool is used.

### Description
The Zip Password Recovery Tool is a utility that uses a brute-force method to recover lost passwords for ZIP archives.

### Features
- **Customizable Character Sets:** Users can select the type of characters included in the password:
  - Standard (lowercase letters and numbers)
  - Standard + Uppercase
  - Standard + Uppercase + Special Characters
- **Maximum Password Length:** Define the maximum password length for testing to tailor the process to your needs.
- **File Selection:** Easily choose a ZIP file from your disk for password recovery.

### Usage
1. Select the character set that matches your password criteria.
2. Specify the maximum length of the password to test.
3. Choose the ZIP file you wish to recover.

### Password break time tests
All tests are conducted as worst-case scenarios, meaning the password may consist of standard, uppercase, and special characters. Additionally, test-case passwords are deliberately chosen from the end of the hard-coded array.  

Java:  

Two character password: 38 seconds

####
The project is still under development. Various libraries and programming languages will be explored to achieve the highest possible efficiency.
