package FormLayout;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class Form {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Form window = new Form();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		FormLayout fl_shell = new FormLayout();
		fl_shell.spacing = 10;
		fl_shell.marginHeight = 10;
		fl_shell.marginWidth = 15;
		shell.setLayout(fl_shell);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.top = new FormAttachment(90);
		fd_btnNewButton.left = new FormAttachment(30);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("B1");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		FormData fd_btnNewButton_1 = new FormData();
		fd_btnNewButton_1.top = new FormAttachment(70);
		fd_btnNewButton_1.left = new FormAttachment(30);
		btnNewButton_1.setLayoutData(fd_btnNewButton_1);
		btnNewButton_1.setText("Btn2");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		FormData fd_btnNewButton_2 = new FormData();
		fd_btnNewButton_2.top = new FormAttachment(50);
		fd_btnNewButton_2.left = new FormAttachment(30);
		btnNewButton_2.setLayoutData(fd_btnNewButton_2);
		btnNewButton_2.setText("Button 3");
		
		Button btnNewButton_3 =new Button(shell, SWT.NONE);
		FormData fd_btnNewButton_3 = new FormData();
		fd_btnNewButton_3.top = new FormAttachment(30);
		fd_btnNewButton_3.left = new FormAttachment(30);
		btnNewButton_3.setLayoutData(fd_btnNewButton_3);
		btnNewButton_3.setText("Wide Button 4");

	}

}
