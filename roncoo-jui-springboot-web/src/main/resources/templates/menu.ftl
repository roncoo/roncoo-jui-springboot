<div id="leftside">
	<div id="sidebar_s">
		<div class="collapse">
			<div class="toggleCollapse">
				<div></div>
			</div>
		</div>
	</div>
	<div id="sidebar">
		<div class="toggleCollapse">
			<h2>主菜单</h2>
			<div>收缩</div>
		</div>

		<div class="accordion" fillSpace="sidebar">
		    <div class="accordionHeader">
                <h2>
                    <span>Folder</span>系统管理
                </h2>
            </div>
            <div class="accordionContent">
                <ul class="tree treeFolder">
                    <li>
                        <a>权限管理</a>
                        <ul>
                            <li><a href="${base}/admin/sysUser/list" target="navTab" rel="admin-sysUser">用户管理</a></li>
                            <li><a href="${base}/admin/sysRole/list" target="navTab" rel="admin-sysRole">角色管理</a></li>
                            <li><a href="${base}/admin/sysMenu/list" target="navTab" rel="admin-sysMenu">菜单管理</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            
			<div class="accordionHeader">
				<h2>
					<span>Folder</span>管理系统
				</h2>
			</div>
			<div class="accordionContent">
				<ul class="tree treeFolder">
					<li>
						<a>系统管理</a>
						<ul>
							<li>
								<a href="${base}/admin/dataDictionary/list" target="navTab" rel="dataDictionary">数据字典管理</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
			
			<div class="accordionHeader">
                <h2>
                    <span>Folder</span>报表管理
                </h2>
            </div>
            <div class="accordionContent">
                <ul class="tree treeFolder">
                    <li>
                        <a>普通报表</a>
                        <ul>
                            <li><a href="${base}/admin/report/list" target="navTab" rel="report">报表统计</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
		</div>
	</div>
</div>