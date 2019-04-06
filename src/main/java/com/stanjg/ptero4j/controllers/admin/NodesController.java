package com.stanjg.ptero4j.controllers.admin;

import com.stanjg.ptero4j.PteroAdminAPI;
import com.stanjg.ptero4j.actions.admin.nodes.NodeUpdateAction;
import com.stanjg.ptero4j.entities.panel.admin.node.Allocation;
import com.stanjg.ptero4j.entities.panel.admin.node.Node;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.stream.Collectors;

public class NodesController extends ResourceController<Node> {

    public NodesController(PteroAdminAPI api, String baseURL, String key) {
        super(api, baseURL, key, "nodes");
    }

    public NodeUpdateAction editNode(int id) {
        return new NodeUpdateAction(getAdminAPI(), id);
    }

    @Override
    protected Node getNewInstance(JSONObject json) {
        return new Node(getAdminAPI(), json);
    }

    public List<Node> getAllNodes() {
        return super.getAllResources();
    }

    public List<Node> getNodes(String search) {
        return super.getResourcesWithQuery(search);
    }

    public Node getNode(int id) {
        return super.getResource(id);
    }

    public List<Allocation> getAllocations(int nodeId) {
        List<JSONObject> res = super.getAllEmbeddedResources(nodeId, "allocations");
        return res.stream().map(j -> new Allocation(getAdminAPI(), j)).collect(Collectors.toList());
    }

    public List<Node> getNodePage(int page) {
        return super.getResourcesPage(page);
    }

    public boolean deleteNode(int id) {
        return super.delete(id);
    }

}
