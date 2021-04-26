In Order to Execute this maven project and start scripts execution Please follow the below steps

Runner file name is RunCukes

To Execute scenario 1 using tag test1
clean test "-Dcucumber.options=--tags @test1" -DdriverType=chrome

To Execute scenario 2 using tag test2

clean test "-Dcucumber.options=--tags @test2" -DdriverType=chrome

Execution reports of dry run inside cucumber folder which is inside target folder


