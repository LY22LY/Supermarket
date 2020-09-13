package SupermarketCashRegister;

import com.bean.SupermarketUser;
import com.dao.DaoSupermarketUser;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class YongHuJpanel extends JPanel implements ActionListener , MouseListener {
	private JPanel jp_west;
	private JPanel jp_east;
	private JTextField jt_guanjianzi;
	private JButton jb_chaxun;
	JLabel jl_guanjianzi;
	DefaultTableModel model;
	JScrollPane jsp_yonghu;
	JTable jt_yonghu;
	JLabel jl_xingming;
	JLabel jl_zhanghao;
	JLabel jl_mima;
	JLabel jl_juese;
	JTextField jt_xingming;
	JTextField jt_zhanghao;
	JTextField jt_mima;
	JComboBox jcb_jifenlv;
	JButton jb_tianjia;
	JButton jb_xiugai;
	JButton jb_shanchu;
	JButton jb_qingkong;

	private DaoSupermarketUser daoSum = new DaoSupermarketUser();
	private ArrayList<SupermarketUser> list;

	public YongHuJpanel() {
		initGui();
	}

	private void initGui() {
		this.setPreferredSize(new Dimension(730, 550));
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		// 西边
		jp_west = new JPanel();
		jp_west.setPreferredSize(new Dimension(420, 600));
		jp_west.setLayout(null);
		jp_west.setBorder(BorderFactory.createTitledBorder("用户查询"));
		// 控件
		jl_guanjianzi = new JLabel("输入姓名或账户:");
		jl_guanjianzi.setBounds(15, 30, 180, 30);
		jt_guanjianzi = new JTextField();
		jt_guanjianzi.setBounds(120, 25, 170, 30);
		jb_chaxun = new JButton("查询");
		jb_chaxun.addActionListener(this);
		jb_chaxun.setBounds(310, 25, 80, 30);
		jsp_yonghu = new JScrollPane();
		jsp_yonghu.setBounds(5, 80, 410, 500);

		// 创建jtable模型
		// tablemap是接口
		// 构造方法三个参数，第一个null第二个是字符串数组
		model = new DefaultTableModel(null, new String[]{"姓名", "账号", "角色"});
		// 创建列表
		jt_yonghu = new JTable(model);
		jsp_yonghu.setViewportView(jt_yonghu);
		jt_yonghu.addMouseListener(this);

		//对表格进行修改
		//查询全部数据
		list = daoSum.selectAll();

		if (list.size() == 0) {
			JOptionPane.showMessageDialog(null, "未连接用户数据库");
		} else {
//			遍历集合
			for (int i = 0; i < list.size(); i++) {
				SupermarketUser user = list.get(i);
//				将需要的数据组成数组，放到addRow方法中
				String[] rowData = {
						user.getuName(), user.getuID(), user.getuRole()
				};
				model.addRow(rowData);
			}
		}

		model.addRow(new String[]{"张三", "admin", "管理员"});
		jp_west.add(jl_guanjianzi);
		jp_west.add(jt_guanjianzi);
		jp_west.add(jb_chaxun);
		jp_west.add(jsp_yonghu);
		this.add(jp_west, BorderLayout.WEST);
		// 东边
		jp_east = new JPanel();

		jp_east.setPreferredSize(new Dimension(280, 600));
		jp_east.setLayout(null);
		jp_east.setBorder(BorderFactory.createTitledBorder("用户管理"));
		jl_xingming = new JLabel("姓名:");
		jl_zhanghao = new JLabel("账号:");
		jl_mima = new JLabel("密码:");
		jl_juese = new JLabel("角色:");
		jl_xingming.setBounds(20, 80, 80, 30);
		jl_zhanghao.setBounds(20, 140, 80, 30);
		jl_mima.setBounds(20, 200, 80, 30);
		jl_juese.setBounds(20, 260, 80, 30);
		jt_xingming = new JTextField();
		jt_zhanghao = new JTextField();
		jt_mima = new JTextField();
		jcb_jifenlv = new JComboBox(new String[]{"管理员", "收银员"});
		jcb_jifenlv.setBounds(80, 260, 170, 30);
		jt_xingming.setBounds(80, 80, 170, 30);
		jt_zhanghao.setBounds(80, 140, 170, 30);
		jt_mima.setBounds(80, 200, 170, 30);
		jb_tianjia = new JButton("添加用户");
		jb_tianjia.addActionListener(this);//添加监听
		jb_xiugai = new JButton("修改用户");
		jb_xiugai.addActionListener(this);//添加监听
		jb_shanchu = new JButton("删除用户");
		jb_shanchu.addActionListener(this);//添加监听
		jb_qingkong = new JButton("清空");
		jb_qingkong.addActionListener(this);//添加监听
		jb_tianjia.setBounds(30, 320, 100, 30);
		jb_xiugai.setBounds(150, 320, 100, 30);
		jb_shanchu.setBounds(30, 380, 100, 30);
		jb_qingkong.setBounds(150, 380, 100, 30);
		jp_east.add(jl_xingming);
		jp_east.add(jl_zhanghao);
		jp_east.add(jl_mima);
		jp_east.add(jl_juese);
		jp_east.add(jt_xingming);
		jp_east.add(jt_zhanghao);
		jp_east.add(jt_mima);
		jp_east.add(jb_tianjia);
		jp_east.add(jb_xiugai);
		jp_east.add(jb_shanchu);
		jp_east.add(jb_qingkong);
		jp_east.add(jcb_jifenlv);
		this.add(jp_east, BorderLayout.EAST);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == jb_chaxun) {
			String info = jt_guanjianzi.getText();
			if (info.equals("")) {
				list = daoSum.selectAll();
				if (list.size() == 0) {
					JOptionPane.showMessageDialog(null, "未连接用户数据库");
				} else {
					//遍历集合
					for (int i = 0; i < list.size(); i++) {
						SupermarketUser user = list.get(i);
						//将需要的数据组成数组，放到addRow方法中
						String[] rowData = {
								user.getuName(), user.getuID(), user.getuRole()
						};
						model.addRow(rowData);
					}
				}
				refreshTable();
			} else {
				//清空表格
				for (int i = model.getRowCount() - 1; i >= 0; i--) {
					model.removeRow(i);
				}
				// 模糊查询
				list = daoSum.selectByNameOrId(info);
				if (list.size() == 0) {
					JOptionPane.showMessageDialog(null, "没有你要查找的信息!");
				} else {
					for (int i = 0; i < list.size(); i++) {
						SupermarketUser user = list.get(i);
						//将需要的数据组成数组，放到addRow方法中
						String[] rowData = {
								user.getuName(), user.getuID(), user.getuRole()
						};
						model.addRow(rowData);
					}
				}
			}
		}
		if (source == jb_tianjia) {
			//1.获取用户数据
			String username = jt_xingming.getText();
			String uid = jt_zhanghao.getText();
			String passworld = jt_mima.getText();
			String urole = (String) jcb_jifenlv.getSelectedItem();
			//2.判断数据是否为空
			if (username.equals("") || uid.equals("") || passworld.equals("") || urole.equals("")) {
				JOptionPane.showMessageDialog(null, "用户名或密码不能为空!");
			} else {
				//3.查看id是否存在
				SupermarketUser u = daoSum.selectById(uid);
				if (u == null) {
					//4.如果不存在，则进行添加
					SupermarketUser user = new SupermarketUser(uid, username, passworld, urole);
					boolean flag = daoSum.insertUser(user);
					if (flag) {
						JOptionPane.showMessageDialog(null, "操作成功!");
						refreshTable();
					} else {
						JOptionPane.showMessageDialog(null, "操作失败!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "此账号已经存在!");
				}
			}

		}
		if (source == jb_xiugai) {
			//1.获取用户数据
			String username = jt_xingming.getText();
			String uid = jt_zhanghao.getText();
			String passworld = jt_mima.getText();
			String urole = (String) jcb_jifenlv.getSelectedItem();
			//2.判断数据是否为空
			if (username.equals("") || uid.equals("") || passworld.equals("") || urole.equals("")) {
				JOptionPane.showMessageDialog(null, "用户名或密码不能为空!");
			} else {
				int a = daoSum.modifyById(uid, username, passworld, urole);
				if (a > 0) {
					JOptionPane.showMessageDialog(null, "修改成功!");
					refreshTable();
				} else {
					JOptionPane.showMessageDialog(null, "修改失败!");
				}
			}

		}
		if (source == jb_shanchu) {
			String username = jt_xingming.getText();
			String uid = jt_zhanghao.getText();
			String passworld = jt_mima.getText();
			String urole = (String) jcb_jifenlv.getSelectedItem();
			//2.判断数据是否为空
			if (username.equals("") || uid.equals("") || passworld.equals("") || urole.equals("")) {
				JOptionPane.showMessageDialog(null, "用户名或密码不能为空!");
			} else {
				int a = daoSum.deleteById(uid);
				if (a > 0) {
					JOptionPane.showMessageDialog(null, "删除成功!");
					refreshTable();
				} else {
					JOptionPane.showMessageDialog(null, "删除失败!");
				}
			}
		}
		if (source == jb_qingkong) {
			jt_xingming.setText("");
			jt_mima.setText("");
			jt_zhanghao.setText("");
			jcb_jifenlv.setSelectedItem("");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 1.获取表格中的数据
		// 获取表格中被选中的行号
		int row = jt_yonghu.getSelectedRow();
		String uname = jt_yonghu.getValueAt(row, 0).toString();
		String uid = jt_yonghu.getValueAt(row, 1).toString();
		String urole = jt_yonghu.getValueAt(row, 2).toString();

		SupermarketUser user1 = daoSum.selectById(uid);
		// 拿出密码
		String upaddword = user1.getuPassword();
		// 将数据放到文本框中
		jt_xingming.setText(uname);
		jt_mima.setText(upaddword);
		jt_zhanghao.setText(uid);
		jcb_jifenlv.setSelectedItem(urole);

		//账号不可编辑
		jt_zhanghao.setEditable(false);

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	/*
        刷新表格
         */
	public void refreshTable() {
		//清空表格
		for (int i = model.getRowCount() - 1; i >= 0; i--) {
			model.removeRow(i);
		}
		// 全部查询
		list = daoSum.selectAll();
		if (list.size() == 0) {
			JOptionPane.showMessageDialog(null, "没有你要查找的信息!");
		} else {
			for (int i = 0; i < list.size(); i++) {
				SupermarketUser user = list.get(i);
				//将需要的数据组成数组，放到addRow方法中
				String[] rowData = {
						user.getuName(), user.getuID(), user.getuRole()
				};
				model.addRow(rowData);
			}

		}
	}
}


