package Application;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import java.util.ArrayList;
import java.util.List;

import Sorter.*;
/**
 * This is a very basic GUI for comparing sorts. but can be adapted to various different 
 * tabular data. Lessons learned were mostly in the sizing of the GUI and how to dynamically resize components to fit the window
 *  
 * @author p2
 *
 */
@SuppressWarnings("serial")
public class View extends JFrame implements WindowListener,ActionListener, ComponentListener  {
	
	// modelList is a table of the sort data, we're retaining this so we cna refesh the models as needed. 
	private List<MyTableModel> modelList = new ArrayList<MyTableModel>();
    // Just the explanation text, it's being tracked for resize. the html tags allow for word wrapping as needed. 
	private JLabel lblControl = new JLabel("<html>Each test time in the table to the right is the average of 200 tests to mostly normalize the data."+
    									   " Refreshing takes a short amount of time as it refreshes all tables.</html>");
	//this is the tabbed section of the GUI, tracking for resize;
	private JTabbedPane tabbedPane = new JTabbedPane();
	//this is a panel holding the refresh button and the explanation label. Tracking for resize.
    private JPanel controlPanel = new JPanel();

   /**
    * Basic entry into the program 
    * @param args
    */
	public static void main(String[] args) 
	{
		new View();
	}
	/**
	 * Constructor and brains of the GUI, 
	 */
	public View()
	{	
		
		//setting up inital size data.
		int winX = 640;
		int winY = 240;
		Dimension winDim = new Dimension(winX,winY);
		Dimension lblDim = new Dimension((winX/4)-20,winY-100);
		Dimension controlDim = new Dimension((winX/4)-10,winY-30);
		Dimension tabbedDim = new Dimension(((winX/4)*3)-10,winY-40);
		
		//GridBag seems to be the best for 
		GridBagConstraints gbc=new GridBagConstraints();
		setLayout(new GridBagLayout());
		
		//These Set up the table models and add them to our list. This could easily be an array. 
		modelList.add( new MyTableModel(new BubbleSort(),200));
		modelList.add( new MyTableModel(new BubbleOptimized(),200));
		modelList.add(new MyTableModel(new CocktailSort(),200));
		modelList.add(new MyTableModel(new InsertionSort(),200));
		modelList.add(new MyTableModel(new CombSort(),200));
		modelList.add(new MyTableModel(new QSort(),200));
		
		//This sets up the tables in the GUI for each sort. Dynamic  
		for(MyTableModel model : modelList)
		{
			JTable table = new JTable(model);
		
			table.setPreferredScrollableViewportSize(new Dimension(500, 70));
			table.setFillsViewportHeight(true);
			table.setDefaultRenderer(Double.class, new milliSecRenderer());
      
			tabbedPane.addTab(model.getSort().getName(), null, new JScrollPane(table), model.getSort().getDescription());
		}
              
        tabbedPane.setPreferredSize(tabbedDim);
        tabbedPane.setSize(tabbedDim);
        tabbedPane.setMinimumSize(tabbedDim);   

        //Refresh button setup
        JButton btnRefreshLists = new JButton("Rerun Tests");
        btnRefreshLists.addActionListener(this);
        btnRefreshLists.setName("refresh");
       
        //Panel for the label and refreshButton so we can resize
        controlPanel.add(lblControl);
        controlPanel.add(btnRefreshLists);
        controlPanel.setPreferredSize(controlDim);
        controlPanel.setSize(controlDim);
        controlPanel.setMinimumSize(controlDim);  
        // initial Size for label
        lblControl.setMinimumSize(lblDim);
        lblControl.setPreferredSize(lblDim);
        
        //This is the set up for the GUI and the Gridbag layout. 
        gbc.fill = GridBagConstraints.NORTH;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1; 
		gbc.gridheight = 1;
		add(controlPanel,gbc); 

        //Add the tabbed pane to this panel.
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
       
        add(tabbedPane,gbc);
	
         
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        this.addComponentListener(this);
        addWindowListener(this);
		setTitle("Sort Comparison");
		setSize(winDim);
		setMinimumSize(winDim);
		setMaximumSize(winDim);
		setVisible(true);
	}
	
	@Override public void actionPerformed(ActionEvent ev)	
	{
		for(MyTableModel m : modelList)
		{
			m.refreshTable();
			m.fireTableDataChanged();
		}
	}	
	
	@Override public void componentResized(ComponentEvent arg0) { 
	
		Dimension winDim = arg0.getComponent().getSize();
		int winX = (int) winDim.getWidth();
		int winY = (int) winDim.getHeight();
	
		Dimension lblDim = new Dimension((winX/4)-20,winY-100);
		Dimension controlDim = new Dimension((winX/4)-10,winY-30);
		Dimension tabbedDim = new Dimension(((winX/4)*3)-10,winY-40);

        controlPanel.setPreferredSize(controlDim);
        controlPanel.setSize(controlDim);
        controlPanel.setMinimumSize(controlDim);  
        lblControl.setMinimumSize(lblDim);
        lblControl.setPreferredSize(lblDim);
        tabbedPane.setPreferredSize(tabbedDim);
        tabbedPane.setSize(tabbedDim);
        tabbedPane.setMinimumSize(tabbedDim);   

	
	}
	@Override public void windowClosing(WindowEvent ev)     	{ System.exit(0);}
	@Override public void windowActivated(WindowEvent ev) 		{ }
	@Override public void windowDeactivated(WindowEvent ev)		{ }
	@Override public void windowDeiconified(WindowEvent ev) 	{ }
	@Override public void windowIconified(WindowEvent ev) 		{ }
	@Override public void windowOpened(WindowEvent ev) 			{ }
	@Override public void windowClosed(WindowEvent ev) 			{ }
	@Override public void componentHidden(ComponentEvent arg0) 	{ }
	@Override public void componentMoved(ComponentEvent arg0) 	{ }

	@Override public void componentShown(ComponentEvent arg0) 	{ }
	
	
	static class milliSecRenderer extends DefaultTableCellRenderer {

	    public milliSecRenderer() { super(); }

	    @Override
		public void setValue(Object value) {

	        setText((value == null) ? "" : String.format("%.5f ms",value));
	    }
	}
	class MyTableModel extends AbstractTableModel {
				
		String[] columnNames = {"Array Size", "Sorted", "Partial", "Random"};
		Object[][] data = new Object[5][4];
		Sort mySort;
		int count;
		
		public MyTableModel(Sort mySort,int count)
		{
			this.mySort = mySort;
			this.count = count;
			refreshTable();
		}
		public void refreshTable()
		{
			data[0] = SetRow("10",  mySort.TestSort(Sort.tenArray[0],count),  mySort.TestSort(Sort.tenArray[1],count),  mySort.TestSort(Sort.tenArray[2],count));
			data[1] = SetRow("50",  mySort.TestSort(Sort.fiftyArray[0],count),mySort.TestSort(Sort.fiftyArray[1],count),mySort.TestSort(Sort.fiftyArray[2],count));
			data[2] = SetRow("100", mySort.TestSort(Sort.hundArray[0],count), mySort.TestSort(Sort.hundArray[1],count), mySort.TestSort(Sort.hundArray[2],count));
			data[3] = SetRow("500", mySort.TestSort(Sort.fiveHArray[0],count),mySort.TestSort(Sort.fiveHArray[1],count),mySort.TestSort(Sort.fiveHArray[2],count));
			data[4] = SetRow("1000",mySort.TestSort(Sort.thouArray[0],count), mySort.TestSort(Sort.thouArray[1],count), mySort.TestSort(Sort.thouArray[2],count));

		}
		protected Object[] SetRow(String s, Double a, Double b, Double c)
		{
			Object[] row = {s,a,b,c};
			return row;
		}
        @Override
		public int getColumnCount() {
            return columnNames.length;
        }
 
        @Override
		public int getRowCount() {
            return data.length;
        }
 
        @Override
		public String getColumnName(int col) {
            return columnNames[col];
        }
 
        @Override
		public Object getValueAt(int row, int col) {
            return data[row][col];
        }
 
        @Override
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
        public Sort getSort()
        {
        	return mySort;
        }
	}


}
