  #ClassTask--> Create a Negative Login Test Feature file with Scenario Outline which includes 4 different data as;
  # eurotech
  # eurotech@
  # eurotech@gmail
  # eurotec@gmail.com
  # Do not forget to take the messages which show the result as negative
  # Use Login_StepDefs class and if needed create locators and methods in related page class
  Feature: Negative Login Test

    @wip
    Scenario Outline: Negative Login Test with Invalid Username
      Given The user is on the login page
      When The user logs in using "<username>" and "<password>"
      Then The warning message should contain '<message>'
      Examples:
        | username          | password   | message                                                                             |
        | eurotech          | Test12345! | Lütfen e-posta adresine bir "@" işareti ekleyin. "eurotech" adresinde "@" eksik.    |
        | eurotech@         | Test12345! | Lütfen "@" işaretinden sonra gelen kısmı ekleyin. "eurotech@", tam bir adres değil. |
        | eurotech@gmail    | Test12345! | Please include a valid email!                                                       |
        | eurotec@gmail.com | Test12345! | Invalid Credentials!                                                                |
        | eurotec@.com      | Test12345! | ".", ".com" adı içinde yanlış bir konumda kullanılmış.                              |
        | eurotec@.         | Test12345! | ".", "." adı içinde yanlış bir konumda kullanılmış.                                 |