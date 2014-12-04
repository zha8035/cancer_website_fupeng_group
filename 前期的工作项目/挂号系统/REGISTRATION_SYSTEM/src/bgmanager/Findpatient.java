package bgmanager;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.graphics.Image;
import patient.PatientInfo;
import patient.PatientInfoList;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Findpatient {

	protected Shell shell;
	private Table table;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Findpatient window = new Findpatient();
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
		shell.setSize(482, 357);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 16, SWT.NORMAL));
		lblNewLabel.setBounds(134, 12, 54, 23);
		lblNewLabel.setText("\u59D3\u540D");
		
		text = new Text(shell, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		text.setBounds(223, 12, 95, 23);
		
		Button findButton = new Button(shell, SWT.NONE);
		findButton.setFont(SWTResourceManager.getFont("楷体", 16, SWT.BOLD));
		findButton.setBounds(40, 52, 80, 27);
		findButton.setText("\u67E5\u8BE2");
		findButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
				table.setBounds(0, 98, 466, 221);
				table.setHeaderVisible(true);
				table.setLinesVisible(true);
				
				TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
				tblclmnNewColumn.setWidth(49);
				tblclmnNewColumn.setText("\u79D1\u5BA4");
				
				TableColumn tblclmnId = new TableColumn(table, SWT.NONE);
				tblclmnId.setWidth(44);
				tblclmnId.setText("Id");
				
				TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
				tableColumn_1.setWidth(54);
				tableColumn_1.setText("\u59D3\u540D");
				
				TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
				tableColumn_2.setWidth(50);
				tableColumn_2.setText("\u5E74\u9F84");
				
				TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
				tableColumn_3.setWidth(57);
				tableColumn_3.setText("\u6027\u522B");		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(84);
				tableColumn.setText("\u8EAB\u4EFD\u8BC1\u53F7");
				
				TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
				tableColumn_4.setWidth(58);
				tableColumn_4.setText("\u5730\u5740");
				
				TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
				tableColumn_5.setWidth(72);
				tableColumn_5.setText("\u533B\u751F");
				
				
				
				PatientInfoList PIF = new PatientInfoList(text.getText());
				TableViewer tableview = new TableViewer(table);
				tableview.setContentProvider(new ArrayContentProvider());
				tableview.setInput(PIF.getPatientInfoList());
				tableview.setLabelProvider(new ITableLabelProvider(){

					public Image getColumnImage(Object arg0, int arg1) {
						// TODO Auto-generated method stub
						return null;
					}

					public String getColumnText(Object arg0, int arg1) {
						// TODO Auto-generated method stub
						PatientInfo pi = (PatientInfo)arg0;
						if(arg1 == 0){
							return pi.getSubject();
						}
						else if(arg1 == 1){
							return (pi.getId()+"");
						}
						else if(arg1 == 2){
							return pi.getName();
						}
						else if(arg1 == 3){
							return pi.getAge()+"";
						}
						else if(arg1 == 4){
							return pi.getSex();
						}
						else if(arg1 == 5){
							return pi.getIdcard();
						}
						else if(arg1 == 6){
							return pi.getAddress();
						}
						else if(arg1 == 7){
							return pi.getDoctor();
						}
						return null;
					}

					public void addListener(ILabelProviderListener arg0) {
						// TODO Auto-generated method stub
						
					}

					public void dispose() {
						// TODO Auto-generated method stub
						
					}

					public boolean isLabelProperty(Object arg0, String arg1) {
						// TODO Auto-generated method stub
						return false;
					}

					public void removeListener(ILabelProviderListener arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
				CellEditor[] celleditor = new CellEditor[8];
				celleditor[0] = null;
				celleditor[1] = new TextCellEditor(table);
				celleditor[2] = new TextCellEditor(table);
				celleditor[3] = new TextCellEditor(table);
				celleditor[4] = new TextCellEditor(table);
				celleditor[5] = new TextCellEditor(table);
				celleditor[6] = new TextCellEditor(table);
				celleditor[7] = new TextCellEditor(table);
				
				final String[] colNames = new String[]{"subject","Id","name","age","sex","Idcard","address","doctor"};
				tableview.setColumnProperties(colNames);
				
				tableview.setCellModifier(new ICellModifier(){

					public boolean canModify(Object arg0, String arg1) {
						// TODO Auto-generated method stub
						return false;
					}

					public Object getValue(Object arg0, String arg1) {
						// TODO Auto-generated method stub
						PatientInfo pi = (PatientInfo)arg0;
						if("subject".equals(arg1))
							return pi.getSubject();
						else if("name".equals(arg1))
							return pi.getName();
						else if("age".equals(arg1))
							return pi.getAge();
						else if("sex".equals(arg1))
							return pi.getSex();
						else if("Idcard".equals(arg1))
							return pi.getIdcard();
						else if("address".equals(arg1))
							return pi.getAddress();
						else if("doctor".equals(arg1))
							return pi.getDoctor();
						return null;
					}

					public void modify(Object arg0, String arg1, Object arg2) {
						// TODO Auto-generated method stub
						TableItem tableitem = (TableItem)arg0;
						PatientInfo pi = (PatientInfo)tableitem.getData();
						if("subjecy".equals(arg1)){
							pi.setSubject((String)arg2);
						}
						else if("name".equals(arg1)){
							pi.setName((String)arg2);
						}
						else if("age".equals(arg1)){
							try{
								pi.setAge(Integer.parseInt((String)arg2));
							}catch(NumberFormatException e){
								e.printStackTrace();
							}
						}
						else if("sex".equals(arg1)){
							pi.setSex((String)arg2);
						}
						else if("Idard".equals(arg1)){
							pi.setIdcard((String)arg2);
						}
						else if("addres".equals(arg1)){
							pi.setAddress((String)arg2);
						}
						else if("doctor".equals(arg1)){
							pi.setDoctor((String)arg2);
						}
					}	
				});
			}
		});
		
		Button exitButton = new Button(shell, SWT.NONE);
		exitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Managermainpage managermain = new Managermainpage();
				shell.dispose();
				managermain.open();
			}
		});
		exitButton.setFont(SWTResourceManager.getFont("楷体", 16, SWT.BOLD));
		exitButton.setBounds(335, 52, 80, 27);
		exitButton.setText("\u8FD4\u56DE");	
		
		Findpatient window2 = new Findpatient();
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewSelecter bs = new btnNewSelecter(window2,shell);
		btnNewButton.addSelectionListener(bs);
		btnNewButton.setFont(SWTResourceManager.getFont("楷体", 16, SWT.BOLD));
		btnNewButton.setBounds(150, 52, 150, 27);
		btnNewButton.setText("\u8FD4\u56DE\u7EE7\u7EED\u67E5\u8BE2");
	}
}
class btnNewSelecter extends SelectionAdapter{
	Findpatient window;
	Shell oldshell;
	public btnNewSelecter(Findpatient window,Shell oldshell){
		this.window = window;
		this.oldshell = oldshell;
	}
	@Override
	public void widgetSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		oldshell.dispose();
		window.open();
	}
}