package de.bergwerklabs.tryjump.unitcreator.metadata;

import com.flowpowered.nbt.*;
import de.bergwerklabs.framework.schematicservice.NbtUtil;
import de.bergwerklabs.framework.schematicservice.metadata.MetadataSerializer;
import de.bergwerklabs.tryjump.api.TryjumpModuleMetadata;
import org.bukkit.util.Vector;

/**
 * Created by Yannic Rieger on 23.09.2017.
 * <p>
 * Deserializes module metadata.
 * @author Yannic Rieger
 */
public class ModuleSerializer implements MetadataSerializer<TryjumpModuleMetadata> {

    @Override
    public CompoundTag serialize(TryjumpModuleMetadata tryjumpModuleMetadata) {
        Vector vector = tryjumpModuleMetadata.getDistanceToEnd();
        CompoundMap map = new CompoundMap();

        map.put(new StringTag("Name", tryjumpModuleMetadata.getName()));
        map.put(new IntTag("Difficulty", tryjumpModuleMetadata.getDifficulty()));
        map.put(new StringTag("IsLite", String.valueOf(tryjumpModuleMetadata.isLite())));
        map.put(NbtUtil.vectorToNbt("DistanceToEnd", vector.getX(), vector.getY(), vector.getZ()));
        map.put(new LongTag("Created", tryjumpModuleMetadata.getCreationTime()));

        return new CompoundTag("Metadata", map);
    }
}
