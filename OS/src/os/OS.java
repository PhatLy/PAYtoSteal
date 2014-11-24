/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

/**
 *
 * @author Ashley
 */
public class OS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileSys fS;
	char ptr = 'a'; 

	String command = "empty";
	String arg1, arg2, com = "";
	int loc;

	while (command != "Q") {

		System.out.println("Enter a command(Q to Quit): ");
		//getline(cin, command);

		//extract command and terms
		loc = command.find(" ");
		if (loc >= 0) {
			com = command.substr(0, loc);
			command = command.substr(loc + 1, command.length() - loc - 1;)
		}
		loc = command.find(" ");
		if (loc >= 0) {
			arg1 = command.substr(0, loc);
			arg2 = command.substr(loc + 1, command.length() - loc - 1;)
		}

	    //call correct command
		if (com == "CREATE") {
			if (arg1 == "U" || arg1 == "D") {
			    ptr = fS.create(arg1, arg2);
		    }
			else {
					cout << "Incorrect sector type" << endl;
			}
		}
		else if (com == "OPEN") {
			if (arg1 == "I" || arg1 == "O" || arg1 == "U") {
    			ptr = fS.open(arg1,arg2);
			}
			else {
				cout << "Incorrect open mode" << endl;
			}
		}
		else if (com == "CLOSE") {
			if (sec != NULL) {
				fS.close(sec);
				sec = NULL;
				cout << "File closed" << endl;
			}
			else {
				cout << "No file open" << endl;
			}

		}
		else if (com == "DELETE") {
			if (fS.dlte(arg1)){
				cout << "Deleted " << arg1 << endl;
			}
			else {
				cout << "File " << arg1 << " not found" << endl;
			}
		}
		else if (com == "READ") {
        	int arg = atoi(arg1.c_str());
			cout << fS.read(arg) << endl; //add pointer arg?
		}
		else if (com == "WRITE") {
			int arg = atoi(arg1.c_str());
			string err = fS.write(arg, arg2); //add pointer arg?
			if (err != "")
				cout << err << endl;
		}
		else if (com == "SEEK") {
			if (arg1 == "-1" || arg1 == "0" || arg1 == "+1") {
				int arg = atoi.(arg2.c_str());
				ptr = fS.seek(ar1, arg2);
			}
			else {
				cout << "Incorrect base type" << endl;
			}
		}
		else if (com == "Q") {}
		else {
			cout << "Command not found, please try again." << endl;
		}
	}
    }
    
}
