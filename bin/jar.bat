REM
cd ..\target\classes
jar cf ..\..\jar\easykin-gui.jar ru\rrozhkov\easykin\gui\*
jar cf ..\..\jar\easykin.jar ru\rrozhkov\easykin\context\* ru\rrozhkov\easykin\data\* ru\rrozhkov\easykin\db\* ru\rrozhkov\easykin\model\* ru\rrozhkov\easykin\util\*
copy  ..\..\jar\easykin.jar ..\..\..\EasyKinWeb\src\main\webapp\WEB-INF\lib\