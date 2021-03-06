package com.nwnu.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.nwnu.pojo.Manager;

/**
 * Filename: MenuPanel.java
 * 
 * ·主菜单界面
 * 
 * @author Luor
 * @version 1.0
 */
public class MenuPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private static int ScreenWidth = 450;
	private static int ScreenHeight = 600;
	private static int ShowScreenWidth = 1200;
	private static int ShowScreenHeight = 660;
	
	/**
	 * ·在此界面进行功能的选择
	 * 
	 * @param win
	 * @param mainPanel
	 * @param manager
	 */
	public MenuPanel(JFrame win, JPanel mainPanel, Manager manager) {
		// clear panel
		mainPanel.removeAll();
		mainPanel.updateUI();
		mainPanel.setLayout(null);
		
		// titlePanel
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.setBounds(ScreenWidth / 2 - 320 / 2, ScreenHeight / 4 - 220 / 2, 320, 60);
		Font titleFont = new Font("宋体", Font.BOLD, 30);
		JLabel labelTitle = new JLabel(manager.getName() + "您好！");
		labelTitle.setFont(titleFont);
		titlePanel.add(labelTitle);
		mainPanel.add(titlePanel);

		// buttonPanel
		// Set border
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		Font mainBorderFont = new Font("宋体", Font.BOLD, 22);
		Font borderFont = new Font("宋体", Font.BOLD, 18);
		Border mainTitleBorder = BorderFactory.createTitledBorder(border, "选择功能", TitledBorder.LEFT, TitledBorder.TOP,
				mainBorderFont);
		Border firstTitleBorder = BorderFactory.createTitledBorder(border, "添加成员信息", TitledBorder.LEFT,
				TitledBorder.TOP, borderFont);
		Border secondTitleBorder = BorderFactory.createTitledBorder(border, "成员信息查询", TitledBorder.LEFT,
				TitledBorder.TOP, borderFont);
		Border thirdTitleBorder = BorderFactory.createTitledBorder(border, "成员信息统计图生成", TitledBorder.LEFT,
				TitledBorder.TOP, borderFont);
		Border fourthTitleBorder = BorderFactory.createTitledBorder(border, "导出成员信息", TitledBorder.LEFT,
				TitledBorder.TOP, borderFont);
		// Create buttonPanel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 1, 10, 10));
		buttonPanel.setBounds(ScreenWidth / 2 - 320 / 2, ScreenHeight / 2 - 360 / 2, 320, 400);
		Font btnFont = new Font("宋体", Font.BOLD, 16);
		// firstPanel
		JPanel firstPanel = new JPanel();
		firstPanel.setLayout(new GridLayout(1, 2, 15, 15));
		JButton btn1 = new JButton("学生信息");
		btn1.setFont(btnFont);
		firstPanel.add(btn1);
		JButton btn2 = new JButton("教师信息");
		btn2.setFont(btnFont);
		firstPanel.add(btn2);
		firstPanel.setBorder(firstTitleBorder);
		buttonPanel.add(firstPanel);
		// secondPanel
		JPanel secondPanel = new JPanel();
		secondPanel.setLayout(new GridLayout(1, 2, 10, 10));
		JButton btn3 = new JButton("学号/工号");
		btn3.setFont(btnFont);
		secondPanel.add(btn3);
		JButton btn4 = new JButton("学/工号+日期");
		btn4.setFont(btnFont);
		secondPanel.add(btn4);
		secondPanel.setBorder(secondTitleBorder);
		buttonPanel.add(secondPanel);
		// thirdPanel
		JPanel thirdPanel = new JPanel();
		thirdPanel.setLayout(new GridLayout(1, 2, 10, 10));
		JButton btn5 = new JButton("感染人数统计");
		btn5.setFont(btnFont);
		thirdPanel.add(btn5);
		JButton btn6 = new JButton("感染区域统计");
		btn6.setFont(btnFont);
		thirdPanel.add(btn6);
		thirdPanel.setBorder(thirdTitleBorder);
		buttonPanel.add(thirdPanel);
		// fourthPanel
		JPanel fourthPanel = new JPanel();
		fourthPanel.setLayout(new GridLayout(1, 1, 10, 10));
		JButton btn7 = new JButton("部门成员信息上报情况统计");
		btn7.setFont(btnFont);
		fourthPanel.add(btn7);
		fourthPanel.setBorder(fourthTitleBorder);
		buttonPanel.add(fourthPanel);
		// Set TitleBorder and add Panel
		buttonPanel.setBorder(mainTitleBorder);
		mainPanel.add(buttonPanel);
		// Add to JFrame
		win.add(mainPanel);
		
		//ActionListener
		btn1.addActionListener(event -> {
			AddInfoPanel addInfoPanel = new AddInfoPanel(win, mainPanel, manager, 0);
			addInfoPanel.setSize(ScreenWidth, ScreenHeight);
		});
		btn2.addActionListener(event -> {
			AddInfoPanel addInfoPanel = new AddInfoPanel(win, mainPanel, manager, 1);
			addInfoPanel.setSize(ScreenWidth, ScreenHeight);
		});
		btn3.addActionListener(event -> {
			SelectInfoPanel selectInfoPanel = new SelectInfoPanel(win, mainPanel, manager, 0);
			selectInfoPanel.setSize(ScreenWidth, ScreenHeight);
		});
		btn4.addActionListener(event -> {
			SelectInfoPanel selectInfoPanel = new SelectInfoPanel(win, mainPanel, manager, 1);
			selectInfoPanel.setSize(ScreenWidth, ScreenHeight);
		});
		btn5.addActionListener(event -> {
			CreateChartFrame(manager, 0);
		});
		btn6.addActionListener(event -> {
			CreateChartFrame(manager, 1);
		});
		btn7.addActionListener(event -> {
			CreateChartFrame(manager);
		});
	}
	
	/**
	 * ·此函数负责完成统计图显示界面的创建
	 * 
	 * @param manager
	 * @param chooseType
	 */
	public void CreateChartFrame(Manager manager, int... chooseType) {
		JFrame showWin = new JFrame();
		JPanel showPanel = new JPanel();

		showPanel.setSize(ShowScreenWidth, ShowScreenHeight);
		
		ShowChartPanel showChartPanel = null;
		ShowPieChartPanel showPieChartPanel = null;
		if (chooseType.length > 0) {
			showChartPanel = new ShowChartPanel(showWin, showPanel, manager, chooseType[0]);
			showChartPanel.setSize(ShowScreenWidth, ShowScreenHeight);

			showWin.setSize(ShowScreenWidth, ShowScreenHeight);
			showWin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			showWin.setLocationRelativeTo(null);
			showWin.setTitle("西北师范大学疫情防控信息统计系统");
			showWin.setResizable(false);
			showWin.setVisible(true);
		} else {
			showPieChartPanel = new ShowPieChartPanel(showWin, showPanel, manager);
			showPieChartPanel.setSize(ShowScreenWidth, ShowScreenHeight);

			showWin.setSize(ShowScreenWidth, ShowScreenHeight);
			showWin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			showWin.setLocationRelativeTo(null);
			showWin.setTitle("西北师范大学疫情防控信息统计系统");
			showWin.setResizable(false);
			showWin.setVisible(true);
		}
	}
	
}
