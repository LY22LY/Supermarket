package SupermarketCashRegister;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.bean.ShopVip;

import com.dao.DaoShopVip;

import tools.DatePicker;


public class HuiYuanJpanel extends JPanel implements ActionListener, MouseListener {
    private JPanel jp_chaxun;
    private JPanel jp_ziliao;
    private JPanel jp_duijiang;
    private JTextField jt_guanjianzi;
    private ArrayList<ShopVip> list2;
    private DefaultTableModel model;
    private DaoShopVip daovip = new DaoShopVip();
    private JButton jb_chaxun;
    private JLabel jl_kahao;
    private JLabel jl_jifen;
    private JLabel jl_xingming;
    private JLabel jl_dianhua;
    private JLabel jl_shengri;
    private JTextField jt_dianhua;
    private JTextField jt_xingming;
    private JTextField jt_kahao;
    private JButton jb_tianjia;
    private JButton jb_xiugai;
    private JButton jb_shanchu;
    private JButton jb_qingkong;
    private JComboBox jcb_jifenlv;
    private JScrollPane jsp_huiyuan;
    private DatePicker dp_shengri;
    private JTable jt_huiyuan;
    private JButton jb_duijiang;
    private JButton jb_chongzhi;
    private JLabel jl_jifenduijiang;
    private JTextField jt_duijiang;
    private JLabel jl_chongzhi;
    private JTextField jt_chongzhi;

    public HuiYuanJpanel() {
        initGUI();
    }

    private void initGUI() {
        // TODO Auto-generated method stub
        this.setPreferredSize(new Dimension(730, 550));
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        //
        // 会员查询
        {
            JLabel jl_guanjianzi = new JLabel("关键字(卡号/姓名/电话)");
            jl_guanjianzi.setBounds(15, 30, 180, 25);
            jp_chaxun = new JPanel();
            jp_chaxun.setPreferredSize(new Dimension(725, 230));
            jp_chaxun.setLayout(null);
            // 设置边框
            jp_chaxun.setBorder(BorderFactory.createTitledBorder("会员查询"));
            this.add(jp_chaxun, BorderLayout.NORTH);
            // 放置关键字文本框
            jt_guanjianzi = new JTextField();
            jt_guanjianzi.setBounds(210, 25, 250, 25);
            jp_chaxun.add(jt_guanjianzi);
            jp_chaxun.add(jl_guanjianzi);
            // 查询按钮
            jb_chaxun = new JButton();
            jb_chaxun.setText("查询");
            jb_chaxun.setBounds(510, 25, 60, 25);
            jp_chaxun.add(jb_chaxun);
            jb_chaxun.addActionListener(this);
//查询列表
            {
                jsp_huiyuan = new JScrollPane();
                jsp_huiyuan.setBounds(5, 55, 700, 170);
                jp_chaxun.add(jsp_huiyuan);
                // 创建jtable模型
                // tablemap是接口
                // 构造方法三个参数，第一个null第二个是字符串数组
                model = new DefaultTableModel(null,
                        new String[] { "卡号", "姓名", "电话", "消费总额", "积分", "消费次数", "积分率", "生日", "余额" });

                // 创建列表
                jt_huiyuan = new JTable(model);
                jt_huiyuan.addMouseListener(this);
                jsp_huiyuan.setViewportView(jt_huiyuan);
//				查询全部数据
                list2 = daovip.selectAll();
                if (list2.size() == 0) {
                    JOptionPane.showMessageDialog(null, "系统用户不存在");

                } else {
                    // 遍历集合，显示
                    for (int i = 0; i < list2.size(); i++) {
                        ShopVip vip = list2.get(i);
                        String[] rowData = { vip.getVId(), vip.getVName(), vip.getVPhone(), vip.getComsume(),
                                vip.getConsumeScore(), vip.getMcount(), vip.getConsumeRate(), vip.getDate(),
                                vip.getVBalance() };
                        model.addRow(rowData);
                    }
                }
                jsp_huiyuan.setViewportView(jt_huiyuan);

                // 添加鼠标点击事件
                jt_huiyuan.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // TODO Auto-generated method stub

                    }
                });
            }

        }
        // 会员资料子面板
        {
            // 加入日期选择框
            dp_shengri = new DatePicker();
            dp_shengri.setBounds(345, 80, 180, 25);

            // 加入下拉列表
            jcb_jifenlv = new JComboBox(new String[] { "0.2", "0.3" });
            jcb_jifenlv.setBounds(75, 130, 180, 30);

            // 其他控件

            jl_kahao = new JLabel("卡号:");
            jl_jifen = new JLabel("积分率:");
            jl_xingming = new JLabel("姓名:");
            jl_dianhua = new JLabel("电话:");
            jl_shengri = new JLabel("生日:");
            jl_jifen.setBounds(20, 130, 60, 30);
            jl_dianhua.setBounds(20, 80, 30, 30);
            jl_shengri.setBounds(295, 80, 30, 30);
            jl_xingming.setBounds(295, 30, 30, 30);
            jt_dianhua = new JTextField();
            jt_xingming = new JTextField();
            jt_kahao = new JTextField();
            jt_dianhua.setBounds(75, 80, 180, 30);
            jt_xingming.setBounds(345, 30, 180, 30);
            jt_kahao.setBounds(75, 30, 180, 30);
            jl_kahao.setBounds(20, 30, 30, 30);
            jb_tianjia = new JButton("添加");
            jb_tianjia.addActionListener(this);
            jb_xiugai = new JButton("修改");
            jb_xiugai.addActionListener(this);
            jb_shanchu = new JButton("删除");
            jb_shanchu.addActionListener(this);
            jb_qingkong = new JButton("清空");
            jb_qingkong.addActionListener(this);
            jb_tianjia.setBounds(545, 30, 60, 35);
            jb_xiugai.setBounds(625, 30, 60, 35);
            jb_shanchu.setBounds(545, 100, 60, 35);
            jb_qingkong.setBounds(625, 100, 60, 35);
            jp_ziliao = new JPanel();
            jp_ziliao.setPreferredSize(new Dimension(725, 150));
            jp_ziliao.setLayout(null);
            jp_ziliao.setBorder(BorderFactory.createTitledBorder("会员资料维护"));
            jp_ziliao.add(jl_kahao);
            jp_ziliao.add(jt_kahao);
            jp_ziliao.add(jl_xingming);
            jp_ziliao.add(jt_xingming);
            jp_ziliao.add(jl_dianhua);
            jp_ziliao.add(jt_dianhua);
            jp_ziliao.add(jl_shengri);
            jp_ziliao.add(jl_jifen);
            jp_ziliao.add(jb_tianjia);
            jp_ziliao.add(jb_shanchu);
            jp_ziliao.add(jb_xiugai);
            jp_ziliao.add(jb_qingkong);
            jp_ziliao.add(dp_shengri);
            jp_ziliao.add(jcb_jifenlv);
            this.add(jp_ziliao, BorderLayout.CENTER);
        }
        // 最下面那个
        {
            jp_duijiang = new JPanel();
            jp_duijiang.setPreferredSize(new Dimension(725, 100));
            jp_duijiang.setLayout(null);
            jp_duijiang.setBorder(BorderFactory.createTitledBorder("兑奖/充值维护"));
            jt_duijiang = new JTextField();

            jt_chongzhi = new JTextField();

            jt_duijiang.setBounds(80, 40, 180, 30);

            jt_chongzhi.setBounds(420, 40, 180, 30);
            jl_jifenduijiang = new JLabel("积分兑奖:");
            jl_chongzhi = new JLabel("充值:");
            jl_jifenduijiang.setBounds(20, 40, 60, 35);
            jl_chongzhi.setBounds(360, 40, 60, 35);
            jb_duijiang = new JButton("兑奖");
            jb_chongzhi = new JButton("充值");
            jb_chongzhi.addActionListener(this);
            jb_duijiang.addActionListener(this);
            jb_duijiang.setBounds(280, 40, 60, 30);
            jb_chongzhi.setBounds(620, 40, 60, 30);
            jp_duijiang.add(jl_jifenduijiang);
            jp_duijiang.add(jl_chongzhi);
            jp_duijiang.add(jt_chongzhi);
            jp_duijiang.add(jt_duijiang);
            jp_duijiang.add(jb_duijiang);
            jp_duijiang.add(jb_chongzhi);
            this.add(jp_duijiang, BorderLayout.SOUTH);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        // 首先获取表格中被选中的行号，getselectrow
        int row = jt_huiyuan.getSelectedRow();
        String VId = jt_huiyuan.getValueAt(row, 0).toString();
        String VName = jt_huiyuan.getValueAt(row, 1).toString();
        String VPhone = jt_huiyuan.getValueAt(row, 2).toString();
        String jifenlve = jt_huiyuan.getValueAt(row, 6).toString();
        String shengri2 = jt_huiyuan.getValueAt(row, 7).toString();

        // 通过id查询用户


        jt_xingming.setText(VName);
        jt_dianhua.setText(VPhone);
        jcb_jifenlv.setSelectedItem(jifenlve);
//				System.out.println(jifenlve);
        dp_shengri.setText(shengri2);
//				System.out.println(jcb_jifenlv.getSelectedItem());
        jt_kahao.setText(VId);

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object o = e.getSource();
        if (o == jb_chaxun) {
            // 模糊查询之前清空表格的内容
            for (int i = model.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            String info = jt_guanjianzi.getText();
            if (info.equals("")) {
                // 查询的空里面为空显示所有数据
                list2 = daovip.selectAll();
                if (list2.size() == 0) {
                    JOptionPane.showMessageDialog(null, "会员不存在");
                } else {
                    // 遍历集合，显示

                    for (int i = 0; i < list2.size(); i++) {
                        ShopVip vip = list2.get(i);
                        String[] rowData = { vip.getVId(), vip.getVName(), vip.getVPhone(), vip.getComsume(),
                                vip.getConsumeScore(), vip.getMcount(), vip.getConsumeRate(), vip.getDate(),
                                vip.getVBalance() };
                        model.addRow(rowData);
                    }
                }
            } else {
                // 模糊查询

                list2 = daovip.selectByNameorIdorPhone(info);
                if (list2.size() == 0) {
                    for (int i = model.getRowCount() - 1; i >= 0; i--) {
                        model.removeRow(i);
                    }
                    JOptionPane.showMessageDialog(null, "会员不存在");
                } else {
                    // 遍历集合，显示
                    for (int i = 0; i < list2.size(); i++) {
                        ShopVip vip = list2.get(i);
                        String[] rowData = { vip.getVId(), vip.getVName(), vip.getVPhone(), vip.getComsume(),
                                vip.getConsumeScore(), vip.getMcount(), vip.getConsumeRate(), vip.getDate(),
                                vip.getVBalance() };
                        model.addRow(rowData);
                    }
                }
            }
        }
        if (o == jb_tianjia) {
            String VName = jt_xingming.getText();
            String VId = jt_kahao.getText(); // 获取id
            String VPhone = jt_dianhua.getText();
            String VBirthday = (String) dp_shengri.getDatePicker();
            String jifenlve = (String) jcb_jifenlv.getSelectedItem(); // 获取下拉列表选项信息
            if (VName.equals("") || VId.equals("") || VPhone.equals("")) {
                JOptionPane.showMessageDialog(null, "账号、姓名或电话不能为空");
            } else {
                // 判断id是否存在
                // 调用控制层的相关方法
                ShopVip vip = daovip.selectById(VId);
                if (vip == null) {
                    // id不存在
                    ShopVip newvip = new ShopVip(VId, VName, VPhone, jifenlve, VBirthday);
                    boolean flag = daovip.insertvip(newvip);
                    // 判断
                    if (flag == true) {
                        JOptionPane.showMessageDialog(null, "插入成功");

                    } else {
                        JOptionPane.showMessageDialog(null, "插入失败");
                    }
                } else {// id存在

                    JOptionPane.showMessageDialog(null, "id账号已经存在");
                }
            }
            for (int i = model.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            list2 = daovip.selectAll();
            for (int i = 0; i < list2.size(); i++) {
                ShopVip vip = list2.get(i);
                String[] rowData = { vip.getVId(), vip.getVName(), vip.getVPhone(), vip.getComsume(),
                        vip.getConsumeScore(), vip.getMcount(), vip.getConsumeRate(), vip.getDate(),
                        vip.getVBalance() };
                model.addRow(rowData);
            }
        }
        if (o == jb_xiugai) {
            String VId = jt_kahao.getText(); // 获取id
            String VName = jt_xingming.getText(); // 获取用户名
            String VPhone = jt_dianhua.getText(); // 获取id
            String data = dp_shengri.getText(); // 获取密码
            String ConsumeRate = (String) jcb_jifenlv.getSelectedItem();
            ShopVip newvip = new ShopVip(VId, VName, VPhone, ConsumeRate, data);
            int count = daovip.change(newvip);
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "修改成功");
            } else {
                JOptionPane.showMessageDialog(null, "修改失败");
            }
            for (int i = model.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            list2 = daovip.selectAll();
            for (int i = 0; i < list2.size(); i++) {
                ShopVip vip = list2.get(i);
                String[] rowData = { vip.getVId(), vip.getVName(), vip.getVPhone(), vip.getComsume(),
                        vip.getConsumeScore(), vip.getMcount(), vip.getConsumeRate(), vip.getDate(),
                        vip.getVBalance() };
                model.addRow(rowData);
            }
        }
        if (o == jb_shanchu) {

            String VId = jt_kahao.getText(); // 获取id

            int count = daovip.shanchu(VId);
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "删除成功");
            } else {
                JOptionPane.showMessageDialog(null, "删除失败");
            }
            for (int i = model.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            list2 = daovip.selectAll();
            for (int i = 0; i < list2.size(); i++) {
                ShopVip vip = list2.get(i);
                String[] rowData = { vip.getVId(), vip.getVName(), vip.getVPhone(), vip.getComsume(),
                        vip.getConsumeScore(), vip.getMcount(), vip.getConsumeRate(), vip.getDate(),
                        vip.getVBalance() };
                model.addRow(rowData);
            }
        }
        if (o == jb_qingkong) {
            jcb_jifenlv.setSelectedItem("");

            dp_shengri.setText("");
            jt_xingming.setText("");
            jt_dianhua.setText("");
            jt_kahao.setText("");
            list2 = daovip.selectAll();
            for (int i = model.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            for (int i = 0; i < list2.size(); i++) {
                ShopVip vip = list2.get(i);
                String[] rowData = { vip.getVId(), vip.getVName(), vip.getVPhone(), vip.getComsume(),
                        vip.getConsumeScore(), vip.getMcount(), vip.getConsumeRate(), vip.getDate(),
                        vip.getVBalance() };
                model.addRow(rowData);
            }
        }
        if (o == jb_duijiang) {
            String VId = jt_kahao.getText();
            ShopVip vip1 = daovip.selectById(VId);
            String jifen = jt_duijiang.getText();
            int count = daovip.duijiang(vip1, jifen);

            list2 = daovip.selectAll();
            for (int i = model.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            for (int i = 0; i < list2.size(); i++) {
                ShopVip vip = list2.get(i);
                String[] rowData = { vip.getVId(), vip.getVName(), vip.getVPhone(), vip.getComsume(),
                        vip.getConsumeScore(), vip.getMcount(), vip.getConsumeRate(), vip.getDate(),
                        vip.getVBalance() };
                model.addRow(rowData);
            }
        }
        if (o == jb_chongzhi) {
            String VId = jt_kahao.getText();
            ShopVip vip1 = daovip.selectById(VId);
            int row = jt_huiyuan.getSelectedRow();
            String yue = jt_chongzhi.getText();

            int count = daovip.addyue(vip1, yue);
            if (count > 0) {
                JOptionPane.showMessageDialog(null, "充值成功");
            } else {
                JOptionPane.showMessageDialog(null, "充值失败");
            }

            int cont2 = daovip.jifen(vip1, yue);// 传积分率

            list2 = daovip.selectAll();
            for (int i = model.getRowCount() - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            for (int i = 0; i < list2.size(); i++) {
                ShopVip vip = list2.get(i);
                String[] rowData = { vip.getVId(), vip.getVName(), vip.getVPhone(), vip.getComsume(),
                        vip.getConsumeScore(), vip.getMcount(), vip.getConsumeRate(), vip.getDate(),
                        vip.getVBalance() };
                model.addRow(rowData);
            }
        }
    }

}
