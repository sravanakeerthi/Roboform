Feature: Roboform fields and functionality validation
		    
    Scenario Outline: Enter different combination of values and submit
	    Given open page https://www.roboform.com/filling-test-custom-fields
		When Enter details "<Salutation>","<Message>","<comments>","<your comments>","<say it here>","<resume>","<age>","<Advertise>","<MaritalStatus>","<unknownimagefiled>","<My id>","<income>","<Annual Salary>"		    
	    Then Submit the form successfully
	    	Examples:
	    	| Salutation | Message     | comments | your comments   | say it here | resume        | age | Advertise | MaritalStatus | unknownmagefield | My id                  | income         | Annual Salary |
		    | Mr         | looking for | a job    | with a          | bachelor    | in Engineering| 17  | yes       | Single        | unknown          | Sravani                | $0 - $11,999   | $0 - $25K     | 
		    | Mrs        | looking for |a parttime| job             | Only 4 hours| a day         | 18  | No        | Married       | blank            | 123456                 | $20,000 - $39,999|$25K - $50K  |  
		    | Dr         | looking for |a teaching| profile         | would teach |English,Science| 19  | yes       | Divorced      |                  | sravankeerthi@gmail.com| >$1,000,000    | $50k+         | 
		    
	Scenario Outline: Reset functionality of roboform
		Given open page https://www.roboform.com/filling-test-custom-fields
		When Enter details "<Salutation>","<Message>","<comments>","<your comments>","<say it here>","<resume>","<age>","<Advertise>","<MaritalStatus>","<unknownimagefiled>","<My id>","<income>","<Annual Salary>"
		Then Reset the form successfully  
		    Examples:
	    	| Salutation | Message     | comments | your comments   | say it here | resume        | age | Advertise | MaritalStatus | unknownmagefield | My id                  | income         | Annual Salary |
		    | Mr         | looking for | a job    | with a          | bachelor    | in Engineering| 17  | yes       | Single        | unknown          | Sravani                | $0 - $11,999   | $0 - $25K     |		    