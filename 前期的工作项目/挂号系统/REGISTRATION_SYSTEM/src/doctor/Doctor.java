package doctor;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Doctor {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Doctor window = new Doctor();
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
		shell.setText("\u533B\u751F\u767B\u9646");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		lblNewLabel.setBounds(169, 78, 39, 24);
		lblNewLabel.setText("\u59D3\u540D");
		
		text = new Text(shell, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		text.setBounds(214, 75, 92, 23);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Î¢ÈíÑÅºÚ", 12, SWT.NORMAL));
		lblNewLabel_1.setBounds(169, 119, 39, 23);
		lblNewLabel_1.setText("\u5BC6\u7801");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text_1.setBounds(214, 104, 92, 23);
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("¿¬Ìå", 18, SWT.BOLD));
		lblNewLabel_2.setBounds(165, 27, 102, 24);
		lblNewLabel_2.setText("\u533B\u751F\u767B\u9646");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			DoctorDAOImpl DDI = new DoctorDAOImpl();
			DoctorR dr = new DoctorR();
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(text_1.getText().equals(DDI.findByname(text.getText()))){
					dr.setName(text.getText());
					Doctormain window = new Doctormain();
					shell.dispose();
					window.open();
				}
			}
		});
		btnNewButton.setFont(SWTResourceManager.getFont("¿¬Ìå", 14, SWT.BOLD));
		btnNewButton.setBounds(133, 187, 80, 27);
		btnNewButton.setText("\u767B\u9646");

	}

}
